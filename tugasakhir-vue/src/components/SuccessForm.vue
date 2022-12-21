<template>
    <div class="sukses">
        <div class="card-body border">
            <h5 class="card-title">Success!</h5>
            <p class="card-text">Data telah di<strong> Tambah {{ pesan }}! </strong></p>
            <router-link to="/" v-if="pesan == 'Inputed'" class="btn btn-primary">Close</router-link>
            <router-link to="/" v-else-if="pesan == 'Updated'" class="btn btn-primary">Back</router-link>
            <button v-else class="btn btn-danger" @click="reloadPage" style="width:70px; height:38px;">Close</button>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            pesan: null,
        }
    },
    methods: {
        ubahPesan() {
            let route = this.$route.fullPath;
            if (route === "/addkk") {
                this.Pesan = "Inputed";
            } else if (route === "/") {
                this.Pesan = "Deleted";
            } else {
                this.Pesan = "Updated";
            }
        },
        reloadPage() {
            location.reload();
        }
    },
    mounted() {
        this.ubahPesan();
    }
}
</script>

<style>
.sukses {
    width: 400px;
    height: 154px;
    background: rgb(255, 181, 90);
    margin-top: 273px;
    margin-left: 490px;
    border-radius: 20px;
}
</style>