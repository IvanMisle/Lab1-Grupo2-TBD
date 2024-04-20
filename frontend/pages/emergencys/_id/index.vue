<template>
    <div class = "card">
        <h2>{{ emergency.id + ".   " + emergency.name}}</h2>
        <p><strong>ID:</strong> {{ emergency.id }}</p>
        <p><strong>Descripción:</strong> {{ emergency.description }}</p>
        <p><strong>ID de Institución:</strong> {{ emergency.id_institution }}</p>
        <p><strong>Responsable del Coordinador:</strong> {{ emergency.responsible_coordinator }}</p>
        <p><strong>Estado:</strong> {{ formattedStatus }}</p>
        <nuxt-link :to="`/emergencys/${emergency.id}/edit`" class="button-link">Editar</nuxt-link>
    </div>
</template>

<script>
import axios from 'axios'
import Emergency from '../../../components/Emergency'

export default{
    components:{
        Emergency
    },

    computed: {
    formattedStatus() {
      return this.emergency.state ? 'Activa' : 'Desactiva';
        }
    },
    data(){
        return{
            emergency:{}
        }
    },
    async created(){
        const response = await axios.get('http://localhost:8081/emergencies/' + this.$route.params.id);
        this.emergency = response.data;
        console.log(this.emergency)
    }
}
</script>

<style>
    .button-link {
    display: inline-block;
    background-color: #3498db;
    color: #ffffff;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    border-radius: 5px;
    cursor: pointer;
    }

    .button-link:hover {
    background-color: #2980b9;
    }

    .card{
        border: 1px solid whitesmoke;
        padding: 3rem;

    }
</style>
