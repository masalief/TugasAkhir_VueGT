<template>
<div class="container">
    <SidebarComponent></SidebarComponent>
    <DetailkkComponent></DetailkkComponent>
</div>
</template>

<script>
import DetailkkComponent from '@/components/DetailkkComponent.vue';
import SidebarComponent from '@/components/SidebarComponent.vue';

export default {
    
    name : "DetailkkPage",

    components : {
        DetailkkComponent,
        SidebarComponent,
    },
};
</script>

<style>

</style>