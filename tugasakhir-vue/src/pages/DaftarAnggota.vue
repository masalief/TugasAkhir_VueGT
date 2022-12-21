<template>
<div class="container">
    <SidebarComponent></SidebarComponent>
    <DaftarAnggotaComponent></DaftarAnggotaComponent>
</div>
</template>

<script>
import SidebarComponent from '@/components/SidebarComponent.vue';
import DaftarAnggotaComponent from '@/components/DaftarAnggotaComponent.vue';

export default {
    
    name : "DaftarAnggotaPage",

    components : {
        SidebarComponent,
        DaftarAnggotaComponent,
    },
};
</script>

<style>

</style>