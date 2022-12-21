<template>
    <div style="width: inherit">
        <div>
            <nav class="ml-5 mt-3 mb-5">
                <h3>Daftar Anggota Keluarga</h3>
                <router-link :to="`/detailkk/${$route.params.id}`"><button type="submit"
                        class="btn btn-primary mt-3 ml-1" style="height: 40px; width: 70px;">Back</button></router-link>
                <router-link :to="`/tambahanggota/${$route.params.id}`"><button type="submit"
                        class="btn btn-warning mt-3 ml-1" style="height: 40px; width: 220px;">Tambah Anggota
                        Keluarga</button></router-link>
            </nav>
        </div>
        <div>
            <div class="ml-5 my-4">
                <h2 class="text-center my4">Daftar Anggota Keluarga</h2>
            </div>
            <table class="table ml-5">
                <thead>
                    <tr class="bg-lightgrey">
                        <th scope="col">No</th>
                        <th scope="col">NIK</th>
                        <th scope="col">Nama</th>
                        <th scope="col">Jenis Kelamin</th>
                        <th scope="col">Kepala Keluarga</th>
                        <th scope="col">Action</th>
                    </tr>
                    <tr>
                        <td colspan="6" class="text-center" v-if="AnggotaKeluargaData.length == 0">Tidak ada Data</td>
                    </tr>
                    <tr v-for="(item, index) in AnggotaKeluargaData" :key="index">
                        <th scope="col">{{ index += 1 }}</th>
                        <th scope="col">{{ item.nik }}</th>
                        <th scope="col">{{ item.nama }}</th>
                        <th scope="col">{{ item.jenis_kelamin }}</th>
                        <th scope="col">{{ item.kepala_keluarga }}</th>
                        <div class="d-flex mt-1 ml-2">
                            <router-link :to="{ path: '/detailanggota/' + item.id }"><button type="button"
                                    class="btn btn-warning mr-1 mb-1 mt-1"
                                    style="width:70px; height:38px;">Detail</button></router-link>
                            <button type="button" class="btn btn-danger ml-1 mb-1 mt-1"
                                @click="deleteAnggotaKeluargaFunction(item.id, item.nik)"
                                style="width:70px; height:38px;">Delete</button>
                        </div>
                    </tr>
                </thead>
            </table>
        </div>
    </div>
</template>

<script>
import AnggotaKeluargaService from '@/service/anggotaservice';

export default {

    name: "DaftarAnggotaPage",

    data() {
        return {
            AnggotaKeluargaData: [],
            success: false,
        };
    },
    mounted() {
        this.getAnggotaKeluarga();
    },
    methods: {
        getAnggotaKeluarga() {
            AnggotaKeluargaService.getAnggotaKeluarga(this.$route.params.id)
                .then((response) => {
                    this.AnggotaKeluargaData = response.data;
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        deleteAnggotaKeluargaFunction(id, nik) {
            if (confirm(`Anda akan menghapus data Anggota Keluarga ${nik}`)) {
                AnggotaKeluargaService.deleteAnggotaKeluarga(id)
                    .then(response => {
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    })
                location.reload();
                this.success = true;
            } else {
                alert("Hapus data di batalkan")
            }
        },
    },
};

</script>

<style>

</style>