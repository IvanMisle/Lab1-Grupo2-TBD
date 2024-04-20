<template>
    <div>
        <header class = "header">
            <h1 class = "text-title">Emergencias</h1>
            <nav>
                <ul>
                    <li>
                        <nuxt-link to="/">Home</nuxt-link>
                    </li>
                    <li>
                        <nuxt-link to="/emergencys">Listado de Emergencias</nuxt-link>
                    </li>
                    <li>
                        <nuxt-link to="/about">Equipo</nuxt-link>
                    </li>
                </ul>
            </nav>
        </header>
        <footer class = footer>
            <p>@Grupo2-Laboratorio1</p>
        </footer>
    </div>
</template>

<style>
    

    .header{
        background: #020303;
        color: #ffff;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 1rem 3rem;
        border-bottom: 4px solid #d27b3d; 
    }

    .header ul{
        display: flex;
        list-style: none;

    }

    .header a{
        color: #ffff;
        background: #2d3436;
        padding: .3rem 1rem;
        margin-right: .5rem;
        text-decoration: none;
        text-transform: uppecase;
    }

    .header a:hover{
        background: #2c3e50;
        border-bottom: 1px solid #bdc3c7;
    }

    .footer{
        background-color: #020303; /* Color morado de Twitch */
        color: white; /* Letras blancas */
        text-align: center;
        padding: 0.1rem;
        position: fixed;
        bottom: 0;
        width: 100%;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; /* Cambia la fuente de letra */
    }
    
    
</style>