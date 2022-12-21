<template>
    <div>

        <div class="mt-3 ml-5">
            <h3>Detail Kartu Keluarga</h3>
        </div>

        <router-link to="/home"><button type="submit" class="btn btn-primary mt-3 ml-5 mr-1"
                style="height: 40px; width: 70px">
                Back
            </button></router-link>

        <button type="submit" class="btn btn-warning mt-3 mr-1" style="height: 40px; width: 200px" v-show="hideButton"
            @click="updateFunction()">
            Update Kartu Keluarga
        </button>

        <router-link :to="`/listanggota/${$route.params.id}`"><button type="submit" class="btn btn-info mt-3"
                style="height: 40px; width: 200px">
                Lihat Anggota Keluarga
            </button></router-link>

        <div>
            <div v-show="!success">
                <form @submit.prevent="updateKartuKeluarga">
                    <div class="d-flex justify-content-center">
                        <div class="form-group col-6">
                            <label for="nomor_kk">Nomor Kartu Keluarga</label>
                            <input v-model="KartuKeluargaData.nomor_kk" name="nomor_kk" type="number"
                                placeholder="Nomor Kartu Keluarga" class="form-control" id="nomor_kk"
                                aria-describedby="emailHelp" :disabled="isDisabled" />
                        </div>
                        <div class="form-group col-6 ml-4">
                            <label for="exampleInputPassword1">Desa / Kelurahan</label>
                            <input v-model="KartuKeluargaData.desa_kelurahan" type="text"
                                placeholder="Desa / Keluarahan" class="form-control" id="desa_kelurahan"
                                :disabled="isDisabled" />
                        </div>
                    </div>
                    <div class="d-flex justify-content-center">
                        <div class="form-group col-6">
                            <label for="exampleInputEmail1">Alamat</label>
                            <textarea v-model="KartuKeluargaData.alamat" type="text" placeholder="Alamat"
                                class="form-control" id="alamat" aria-describedby="emailHelp"
                                :disabled="isDisabled"></textarea>
                            <!-- style="resize:none;width:490px;height:150px;" -->
                        </div>
                        <div class="form-group col-6 ml-4">
                            <label for="exampleInputPassword1">Kecamatan</label>
                            <input v-model="KartuKeluargaData.kecamatan" type="text" placeholder="Kecamatan"
                                class="form-control" id="kecamatan" :disabled="isDisabled" />
                        </div>
                    </div>
                    <div class="d-flex justify-content-center">
                        <div class="form-group col-6">
                            <label for="exampleInputEmail1">RT</label>
                            <input v-model="KartuKeluargaData.rt" type="number" placeholder="RT" class="form-control"
                                id="rt" aria-describedby="emailHelp" :disabled="isDisabled" />
                        </div>
                        <div class="form-group col-6 ml-4">
                            <label for="exampleInputPassword1">Kabupaten / Kota</label>
                            <input v-model="KartuKeluargaData.kabupaten_kota" type="text" placeholder="Kabupaten / Kota"
                                class="form-control" id="kabupaten_kota" :disabled="isDisabled" />
                        </div>
                    </div>
                    <div class="d-flex justify-content-center">
                        <div class="form-group col-6">
                            <label for="exampleInputEmail1">RW</label>
                            <input v-model="KartuKeluargaData.rw" type="number" placeholder="RW" class="form-control"
                                id="rw" aria-describedby="emailHelp" :disabled="isDisabled" />
                        </div>
                        <div class="form-group col-6 ml-4">
                            <label for="exampleInputPassword1">Provinsi</label>
                            <input v-model="KartuKeluargaData.provinsi" type="text" placeholder="Provinsi"
                                class="form-control" id="provinsi" :disabled="isDisabled" />
                        </div>
                    </div>
                    <div class="d-flex">
                        <div class="kodepos form-group col-6">
                            <label for="exampleInputEmail1">Kode Pos</label>
                            <input v-model="KartuKeluargaData.kode_pos" type="number" placeholder="Kode Pos"
                                class="form-control" id="kode_pos" aria-describedby="emailHelp"
                                :disabled="isDisabled" />
                        </div>
                    </div>
                    <button class="btn btn-danger mt-3 mr-1" style="height: 40px; width: 80px"
                        @click.prevent="showDetailCancel" v-show="updateButton">
                        Cancel
                    </button>
                    <button type="submit" class="btn btn-warning mt-3" style="height: 40px; width: 80px"
                        v-show="updateButton">
                        Update
                    </button>
                </form>
            </div>
            <SuccessUpdateKK v-show="success"></SuccessUpdateKK>
        </div>
    </div>

</template>

<script>
import KartuKeluargaService from "../service/kartuservice.js";
import SuccessUpdateKK from "../components/SuccessUpdateKK.vue";

export default {
    data() {
        return {
            KartuKeluargaData: {
                alamat: null,
                desa_kelurahan: null,
                kabupaten_kota: null,
                kecamatan: null,
                kode_pos: null,
                nomor_kk: null,
                provinsi: null,
                rt: null,
                rw: null,
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
        cancelUpdateKK() {
            location.reload();
        },
        updateKartuKeluarga() {
            let data = this.KartuKeluargaData;
            let id = this.$route.params.id;
            KartuKeluargaService.updateKartuKeluarga(id, data)
                .then((response) => {
                    this.KartuKeluargaData = response.data;
                    console.log(response.data);
                    this.success = true;
                })
                .catch((e) => {
                    console.log(e);
                });
        },
        getKartuById() {
            let id = this.$route.params.id;
            KartuKeluargaService.getKartuById(id)
                .then((response) => {
                    this.KartuKeluargaData = response.data;
                    console.log(this.KartuKeluargaData);
                })
                .catch((e) => {
                    console.log(e);
                });
        },
    },
    mounted() {
        this.getKartuById();
    },

    components: {
        SuccessUpdateKK,
    }
};
</script>

<style scoped>
form {
    width: 77%;
    height: 96%;
    margin-left: 100px;
    margin-top: 160px;
}

.kodepos {
    margin-left: 51%;
}
</style>
