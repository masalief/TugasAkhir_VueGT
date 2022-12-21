<template>
    <div class="">
        <div v-show="SuccessTambahAnggota">
            <SuccessTambahAnggota></SuccessTambahAnggota>
        </div>
        <div v-show="!SuccessTambahAnggota">
            <div class="mt-3 ml-5">
                <h3>Tambah Anggota Keluarga</h3>
            </div>
            <router-link :to="`/detailanggota/${$route.params.id}`"><button type="submit"
                    class="btn btn-primary mt-3 ml-5 mr-1"
                    style="height: 40px; width: 70px;">Back</button></router-link>
            <form class="form" @submit.prevent="inputAnggotaKeluarga">
                <div class="d-flex justify-content-center">
                    <div class="form-group col-6">
                        <label for="exampleInputEmail1">NIK</label>
                        <input type="number" placeholder="NIK" class="form-control" id="exampleInputEmail1"
                            aria-describedby="emailHelp" v-model="AnggotaKeluargaData.nik">
                    </div>
                    <div class="form-group col-6 ml-4">
                        <label for="exampleInputPassword1">Tanggal Lahir</label>
                        <input type="date" placeholder="Tanggal Lahir" class="form-control" id="exampleInputPassword1"
                            v-model="AnggotaKeluargaData.tanggal_lahir">
                    </div>
                </div>
                <div class="d-flex justify-content-center">
                    <div class="form-group col-6">
                        <label for="exampleInputEmail1">Nama</label>
                        <input type="text" placeholder="Nama" class="form-control" id="exampleInputEmail1"
                            aria-describedby="emailHelp" v-model="AnggotaKeluargaData.nama">
                    </div>
                    <div class="form-group col-6 ml-4">
                        <label for="exampleInputPassword1">Agama</label>
                        <input type="text" placeholder="Agama" class="form-control" id="exampleInputPassword1"
                            v-model="AnggotaKeluargaData.agama">
                    </div>
                </div>
                <div class="d-flex justify-content-center">
                    <div class="form-group col-6">
                        <label for="exampleInputEmail1">Jenis Kelamin</label>
                        <select type="text" placeholder="Jenis Kelamin" class="form-control" id="exampleInputEmail1"
                            aria-describedby="emailHelp" v-model="AnggotaKeluargaData.jenis_kelamin">
                            <option selected></option>
                            <option>Pria</option>
                            <option>Wanita</option>
                        </select>
                    </div>
                    <div class="form-group col-6 ml-4">
                        <label for="exampleInputPassword1">Pendidikan</label>
                        <input type="text" placeholder="Pendidikan" class="form-control" id="exampleInputPassword1"
                            v-model="AnggotaKeluargaData.pendidikan">
                    </div>
                </div>
                <div class="tempatlahir d-flex">
                    <div class="form-group col-6">
                        <label for="exampleInputEmail1">Tempat Lahir</label>
                        <input type="text" placeholder="Tempat Lahir" class="form-control" id="exampleInputEmail1"
                            aria-describedby="emailHelp" v-model="AnggotaKeluargaData.tempat_lahir">
                    </div>
                    <div class="form-group col-6 ml-3">
                        <label for="exampleInputEmail1">Kepala Keluarga</label>
                        <select type="text" placeholder="Kepala Keluarga" class="form-control" id="exampleInputEmail1"
                            aria-describedby="emailHelp" v-model="AnggotaKeluargaData.kepala_keluarga">
                            <option selected></option>
                            <option>Yes</option>
                            <option>No</option>
                        </select>
                    </div>
                </div>

                <button type="submit" class="btn btn-success mt-3" style="height: 40px; width: 80px;"
                    @click="addIdKK">Submit</button>
            </form>
        </div>
    </div>
</template>

<script>
import AnggotaKeluargaService from '@/service/anggotaservice';
import SuccessTambahAnggota from '@/components/SuccessTambahAnggota.vue';

export default {
    components: {
        SuccessTambahAnggota,
    },
    data() {
        return {
            AnggotaKeluargaData: {
                agama: null,
                id_kk: null,
                jenis_kelamin: null,
                kepala_keluarga: null,
                nama: null,
                nik: null,
                pedidikan: null,
                tanggal_lahir: null,
                tempat_lahir: null,
            },
            SuccessTambahAnggota: false,
        };
    },

    methods: {

        addIdKK() {
            this.AnggotaKeluargaData.id_kk = this.$route.params.id;
        },
        inputAnggotaKeluarga() {
            this.AnggotaKeluargaData.id_kk = this.$route.params.id
            let data = this.AnggotaKeluargaData;

            AnggotaKeluargaService
                .create(data)
                .then(
                    this.SuccessTambahAnggota = true)
                .catch((e) => {
                    console.log(e);
                });
        },
    },
};
</script>

<style scoped>
form {
    width: 77%;
    height: 90%;
    margin-left: 100px;
    margin-top: 90px;
}

.tempatlahir {
    margin-left: -15px;
}
</style>