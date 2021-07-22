<template v-slot:title>
  <a-layout id="components-layout-demo-top-side-2">
    <the-header></the-header>
    <router-view/>
    <the-footer></the-footer>

  </a-layout>
</template>


<script lang="ts">
import { defineComponent } from 'vue';
import TheHeader from '@/components/the-header.vue'; // @ is an alias to /src
import TheFooter from '@/components/the-footer.vue'; // @ is an alias to /src


export default defineComponent({
  name: 'app',
  components: {
    TheFooter,
    TheHeader
  },
});
</script>



<style>
#components-layout-demo-top-side-2 .logo {
  width: 120px;
  height: 31px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px 28px 16px 0;
  float: left;
}


#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
