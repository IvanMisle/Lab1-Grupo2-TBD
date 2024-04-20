<template>
    <v-navigation-drawer v-model="drawerVisible">
      <v-list-item title = "Paginas"></v-list-item>
      <v-divider></v-divider>
        <v-list-item v-for="(item, index) in icons" :key="index" :to="item.to">
            <v-icon>{{ item.icon }}</v-icon>
            {{ item.title }}
        </v-list-item>
    </v-navigation-drawer>
    <v-btn @click="cambiarBarra" height="30px">{{ drawerVisible ? 'Ocultar' : 'Mostrar' }} barra lateral</v-btn>
</template>

<script>
export default {
  name: 'NavigationBar',
  data() {
    return {
        drawerVisible: false,
      icons: [{
        title: 'Login',
        icon: 'mdi-account',
        to: '/'
      },
      {
        title: 'Emergencias',
        icon: 'mdi-alert',
        to: '/EmergenciesPage'
      }]
    }
  },
  methods: {
    cambiarBarra() {
      this.drawerVisible = !this.drawerVisible;
    }
  }
}
</script>