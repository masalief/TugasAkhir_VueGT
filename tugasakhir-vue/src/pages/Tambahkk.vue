<template>
<div class="container">
    <SidebarComponent></SidebarComponent>
    <TambahkkComponent></TambahkkComponent>
</div>
</template>

<script>
import TambahkkComponent from '@/components/TambahkkComponent.vue';
import SidebarComponent from '@/components/SidebarComponent.vue';

export default {
    name : "TambahkkPage",

    components : {
      TambahkkComponent, 
      SidebarComponent, 
    }
}
</script>

<style>

</style>