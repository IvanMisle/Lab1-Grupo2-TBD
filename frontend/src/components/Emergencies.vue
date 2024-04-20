<template>
    <div>
        <v-data-table v-if="emergencies" :items="emergencies"></v-data-table>
    </div>
    <v-btn @click="changeStateEmergency">
      Activar/Desactivar emergencia
    </v-btn>
    <input type="number" placeholder=" Ingrese el index" style="margin-left: 10px;" v-model="inputid">
</template>


<script>
import axios from 'axios';
import {ref} from 'vue';

export default {
  data() {
    return {
      emergencies: ref(null),
      inputid: null
    };
  },

  created() {
    this.getEmergencies();
  },
  
  methods: {
    async getEmergencies() {
      try{
        const response = await axios.get('http://localhost:8080/emergencies');
        this.emergencies = await Promise.all(response.data.map(async item => {
          let estado;
          if (item.state) {
            estado = "activa";
          } else {
            estado = "inactiva";
          }
          const activeTasks = await this.getActiveTask(item.id);
          return {
            index: item.id,
            nombre: item.name,
            descripcion: item.description,
            estado: estado,
            "id de institucion": item.id_institution,
            coordinador: item.responsible_coordinator,
            "tareas activas": activeTasks
          };
        }));
      } catch (error) {
        console.error('Error al hacer la solicitud getEmergencies: ', error);
      };
    },
    async getActiveTask(idEmergency) {
      try{
        const response = await axios.get('http://localhost:8080/emergencies/getActiveTasksCount/' + idEmergency);
        return response.data;
      } catch (error) {
        console.error('Error al hacer la solicitud getActiveTask: ', error);
      };
    },
    async changeStateEmergency(){
      let emergency = this.emergencies[this.inputid - 1];
      let state = true;
      if(emergency["estado"] === "activa"){
        state = false;
      }
      await axios.put('http://localhost:8080/emergencies/' + this.inputid, {
        "id": this.inputid,
        "id_institution": emergency["id de institucion"],
        "state": state,
        "name": emergency["nombre"],
        "description": emergency["descripcion"],
        "responsible_coordinator": emergency["coordinador"]
      });
      this.getEmergencies();
    }
  }
};
</script>