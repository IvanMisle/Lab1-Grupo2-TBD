<template>
    <div>
        <h1>Editar Emergencia</h1>
        <p><strong>ID:</strong> {{ emergency.id }}</p>
        <p><strong>Nombre:</strong> {{ emergency.name }}</p>
        <!-- Otros campos de edición -->

       <button @click="toggleEmergencyStatus">{{ emergency.state ? 'Desactivar' : 'Activar' }} Emergencia</button>
    </div>
</template>
  
<script>
import axios from 'axios'
  
  export default {
    data() {
      return {
        emergency: {}
      }
    },
    async created() {
      try {
        const response = await axios.get('http://localhost:8081/emergencies/' + this.$route.params.id);
        this.emergency = response.data;
        console.log(this.emergency)
      } catch (error) {
        console.error('Error al obtener los detalles de la emergencia:', error);
      }
    },
    methods: {
      async toggleEmergencyStatus() {
        try {
          // Invertir el estado actual
          this.emergency.state = !this.emergency.state;
          
          // Enviar una solicitud PUT al backend para actualizar el estado de la emergencia
          await axios.put('http://localhost:8081/emergencies/' + this.$route.params.id, this.emergency,{
            state: this.emergency.state
          });
          
          // Mensaje de éxito o actualización de la interfaz de usuario según sea necesario
          console.log('Estado de la emergencia actualizado correctamente:', this.emergency.state);
        } catch (error) {
          console.error('Error al actualizar el estado de la emergencia:', error);
          // Revertir el estado en caso de error
          this.emergency.state = !this.emergency.state;
        }
      }
    }
  }
</script>
  
<style>
/* Estilos según sea necesario */
</style>
  