<template>
    <div class="container">
        <SidebarComponent></SidebarComponent>
        <DetailAnggotaComponent></DetailAnggotaComponent>
    </div>
</template>

<script>
import SidebarComponent from '@/components/SidebarComponent.vue';
import DetailAnggotaComponent from '@/components/DetailAnggotaComponent.vue';

export default {

    name: "DetailAnggotaPage",

    components: {
        SidebarComponent,
        DetailAnggotaComponent,
    },
};
</script>

<style>

</style>