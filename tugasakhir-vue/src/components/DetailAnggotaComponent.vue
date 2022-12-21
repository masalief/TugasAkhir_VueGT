<template>
    <div>
        <div class="mt-3 ml-5">
            <h3>Detail Anggota Keluarga</h3>
        </div>

        <router-link :to="`/listanggota/${$route.params.id}`"><button type="submit"
                class="btn btn-primary mt-3 ml-5 mr-1" style="height: 40px; width: 70px;">Back</button></router-link>

        <button type="submit" class="btn btn-warning mt-3" style="height: 40px; width: 150px;" v-show="hideButton"
            @click="updateFunction()">Update Anggota</button>

        <div>
            <div v-show="!success">
                <form @submit.prevent="updateAnggotaKeluarga">
                    <div class="d-flex justify-content-center">
                        <div class="form-group col-6">
                            <label for="exampleInputEmail1">NIK</label>
                            <input type="number" placeholder="NIK" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp" v-model="AnggotaKeluargaData.nik" :disabled="isDisabled">
                        </div>
                        <div class="form-group col-6 ml-4">
                            <label for="exampleInputPassword1">Tanggal Lahir</label>
                            <input type="date" placeholder="Tanggal Lahir" class="form-control"
                                id="exampleInputPassword1" v-model="AnggotaKeluargaData.tanggal_lahir"
                                :disabled="isDisabled">
                        </div>
                    </div>
                    <div class="d-flex justify-content-center">
                        <div class="form-group col-6">
                            <label for="exampleInputEmail1">Nama</label>
                            <input type="text" placeholder="Nama" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp" v-model="AnggotaKeluargaData.nama" :disabled="isDisabled">
                        </div>
                        <div class="form-group col-6 ml-4">
                            <label for="exampleInputPassword1">Agama</label>
                            <input type="text" placeholder="Agama" class="form-control" id="exampleInputPassword1"
                                v-model="AnggotaKeluargaData.agama" :disabled="isDisabled">
                        </div>
                    </div>
                    <div class="d-flex justify-content-center">
                        <div class="form-group col-6">
                            <label for="exampleInputEmail1">Jenis Kelamin</label>
                            <select type="text" placeholder="Jenis Kelamin" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp" v-model="AnggotaKeluargaData.jenis_kelamin"
                                :disabled="isDisabled">
                                <option selected></option>
                                <option>Pria</option>
                                <option>Wanita</option>
                            </select>
                        </div>
                        <div class="form-group col-6 ml-4">
                            <label for="exampleInputPassword1">Pendidikan</label>
                            <input type="text" placeholder="Pendidikan" class="form-control" id="exampleInputPassword1"
                                v-model="AnggotaKeluargaData.pendidikan" :disabled="isDisabled">
                        </div>
                    </div>
                    <div class="d-flex justify-content-center">
                        <div class="form-group col-6">
                            <label for="exampleInputEmail1">Tempat Lahir</label>
                            <input type="text" placeholder="Tempat Lahir" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp" v-model="AnggotaKeluargaData.tempat_lahir"
                                :disabled="isDisabled">
                        </div>
                        <div class="form-group col-6">
                            <label for="exampleInputEmail1">Kepala Keluarga</label>
                            <select type="text" placeholder="Kepala Keluarga" class="form-control"
                                id="exampleInputEmail1" aria-describedby="emailHelp"
                                v-model="AnggotaKeluargaData.kepala_keluarga" :disabled="isDisabled">
                                <option selected></option>
                                <option>Yes</option>
                                <option>No</option>
                            </select>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-danger mt-3 mr-1" style="height: 40px; width: 80px;"
                        @click.prevent="showDetailCancel" v-show="updateButton">Cancel</button>
                    <button type="submit" class="btn btn-success mt-3" style="height: 40px; width: 80px;"
                        v-show="updateButton">Update</button>
                </form>
            </div>
            <SuccessUpdateAnggota v-show="success"></SuccessUpdateAnggota>
        </div>
    </div>
</template>

<script>
import AnggotaKeluargaService from "../service/anggotaservice.js";
import SuccessUpdateAnggota from "../components/SuccessUpdateAnggota.vue";
import anggotaservice from '../service/anggotaservice.js';

export default {
    data() {
        return {
            AnggotaKeluargaData: {
                agama: null,
                jenis_kelamin: null,
                kepala_keluarga: null,
                nama: null,
                nik: null,
                pendidikan: null,
                tanggal_lahir: null,
                tempat_lahir: null,
            },
            success: false,
            updateButton: false,
            hideButton: true,
            isDisabled: true,
        };
    },
    methods: {
        updateFunction() {
            this.updateButton = true;
            this.hideButton = false;
            this.isDisabled = false;
        },
        refreshFunction() {
            this.updateButton = false;
            this.hideButton = true;
            this.isDisabled = true;
        },
        showDetailCancel() {
            // this.$emit('showDetail');
            this.updateButton = !this.updateButton;
            this.isDisabled = !this.isDisabled;
            this.hideButton = !this.hideButton
            // this.success = false;
        },
        updateAnggotaKeluarga() {
            let data = this.AnggotaKeluargaData;
            let id = this.$route.params.id;
            AnggotaKeluargaService.updateAnggotaKeluarga(id, data)
                .then((response) => {
                    this.AnggotaKeluargaData = response.data;
                    console.log(response.data);
                    this.success = true;
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        getAnggotaById() {
            let id = this.$route.params.id;
            anggotaservice.getAnggotaById(id)
                .then((response) => {
                    this.AnggotaKeluargaData = response.data;
                    console.log(this.AnggotaKeluargaData);
                })
                .catch((e) => {
                    console.log(e);
                });
        },


    },
    mounted() {
        this.getAnggotaById();
    },
    components: {
        SuccessUpdateAnggota,
    }

};
</script>

<style scoped>
form {
    width: 77%;
    height: 80%;
    margin-left: 100px;
    margin-top: 80px;
}
</style>