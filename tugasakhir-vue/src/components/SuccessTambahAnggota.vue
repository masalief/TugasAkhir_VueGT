<template>
    <div class="sukses">
        <div class="card-body border">
            <h5 class="card-title">Success!</h5>
            <p class="card-text">Data Anggota keluarga telah di Tambah</p>
            <router-link to="/home"><button class="btn btn-danger" @click="showDetail"
                    style="width:70px; height:38px;">Close</button></router-link>
        </div>
    </div>
</template>

<script>
export default {
    name: "SuccessTambahAnggota",

    methods: {
        showDetail() {
            this.$emit('showDetail')
        }
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