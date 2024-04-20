<template>
    <div>
        <h1>Listado de Emergencias</h1>
        <Emergency
            v-for="emergency of emergencys"
            :key="emergency.id"
            :title ="emergency.title"
            :id = "emergency.id"
            :content="emergency.body"
            :description="emergency.description"
            :name="emergency.name"
            :state="emergency.state"
        />
    </div>
</template>

<script>
import axios from 'axios'
import Emergency from'../../components/Emergency'

export default{
    components:{
        Emergency
    },

    data() {
        return{
            emergencys:[]
        }
    },
    async created(){
        try {
            const res = await axios.get('http://localhost:8081/emergencies');
            this.emergencys = res.data;
            console.log(this.emergencys)
        } catch (error) {
            console.log(error)
            
        }
    }
    
}
</script>
