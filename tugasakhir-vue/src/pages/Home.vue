<template>
<div class="container">
    <SidebarComponent></SidebarComponent>
    <HomeComponent class="homecomponent"></HomeComponent>
</div>
</template>

<script>
import HomeComponent from '@/components/HomeComponent.vue';
import SidebarComponent from '@/components/SidebarComponent.vue';

export default {

    name : "HomePage",

    components : {
        HomeComponent,
        SidebarComponent,
    },

};
</script>

<style>

.container {
    display: flex;
    margin: 0;
    padding: 0;
}
.homecomponent {
    margin-left: calc(10px + 1rem);
    /* margin-left: 220px; */
}

</style>