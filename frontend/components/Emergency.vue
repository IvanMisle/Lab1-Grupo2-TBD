<template>
    <nuxt-link :to="'/emergencys/' + id">
        <div class = "emergency">
            <p>{{ id }}. {{ name }}</p>
        </div>
    </nuxt-link>
</template>


<script>
    
export default {
    name: 'Emergency',
    props: ['id', 'name']
}
</script>

<style>
    .emergency{
        padding: 1rem;
        border: 1px solid whitesmoke;
        margin: 1rem 0;
    }

    .emergency:hover{
        background: #2d3436;
        border: 1px solid #6c5ce7;
        cursor:pointer;
    }

    a{
        color: whitesmoke;
        text-decoration : none;
    }

    a:hover{
        color: #6c5ce7;
    }

</style>