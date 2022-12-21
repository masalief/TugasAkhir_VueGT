<template>
<div class="container">
    <SidebarComponent></SidebarComponent>
    <TambahAnggotaComponent></TambahAnggotaComponent>
</div>
</template>

<script>
import SidebarComponent from '@/components/SidebarComponent.vue';
import TambahAnggotaComponent from '@/components/TambahAnggotaComponent.vue';

export default {
    
    name : "TambahAnggotaPage",

    components : {
        SidebarComponent,
        TambahAnggotaComponent,
    }
}
</script>

<style>

</style>