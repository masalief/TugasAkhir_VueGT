<template>
  <div class="about">
    <div v-show="SuccessForm">
      <SuccessForm></SuccessForm>
    </div>
    <div v-show="!SuccessForm">
      <div>
        <div class="mt-3 ml-5">
          <h3>Tambah Kartu Keluarga</h3>
        </div>
        <router-link to="/home"><button type="submit" class="btn btn-primary mt-3 ml-5"
            style="height: 40px; width: 70px;">Back</button></router-link>
      </div>

      <form class="form" @submit.prevent="inputKartuKeluarga">
        <div class="d-flex justify-content-center">
          <div class="form-group col-6">
            <label for="nomor_kk">Nomor Kartu Keluarga</label>
            <input type="number" placeholder="Nomor Kartu Keluarga" class="form-control" id="exampleInputEmail1"
              aria-describedby="emailHelp" v-model="KartuKeluargaData.nomor_kk">
          </div>
          <div class="form-group col-6 ml-4">
            <label for="desa_kelurahan">Desa / Kelurahan</label>
            <input type="text" placeholder="Desa / Keluarahan" class="form-control" id="exampleInputPassword1"
              v-model="KartuKeluargaData.desa_kelurahan">
          </div>
        </div>
        <div class="d-flex justify-content-center">
          <div class="form-group col-6">
            <label for="alamat">Alamat</label>
            <textarea type="address" placeholder="Alamat" class="form-control" id="exampleInputEmail1"
              aria-describedby="emailHelp" v-model="KartuKeluargaData.alamat"></textarea>
          </div>
          <div class="form-group col-6 ml-4">
            <label for="kecamatan">Kecamatan</label>
            <input type="text" placeholder="Kecamatan" class="form-control" id="exampleInputPassword1"
              v-model="KartuKeluargaData.kecamatan">
          </div>
        </div>
        <div class="d-flex justify-content-center">
          <div class="form-group col-6">
            <label for="rt">RT</label>
            <input type="number" placeholder="RT" class="form-control" id="exampleInputEmail1"
              aria-describedby="emailHelp" v-model="KartuKeluargaData.rt">
          </div>
          <div class="form-group col-6 ml-4">
            <label for="kabupaten_kota">Kabupaten / Kota</label>
            <input type="text" placeholder="Kabupaten / Kota" class="form-control" id="exampleInputPassword1"
              v-model="KartuKeluargaData.kabupaten_kota">
          </div>
        </div>
        <div class="d-flex justify-content-center">
          <div class="form-group col-6">
            <label for="rw">RW</label>
            <input type="number" placeholder="RW" class="form-control" id="exampleInputEmail1"
              aria-describedby="emailHelp" v-model="KartuKeluargaData.rw">
          </div>
          <div class="form-group col-6 ml-4">
            <label for="provinsi">Provinsi</label>
            <input type="text" placeholder="Provinsi" class="form-control" id="exampleInputPassword1"
              v-model="KartuKeluargaData.provinsi">
          </div>
        </div>
        <div class="d-flex">
          <div class="kodepos form-group col-6">
            <label for="kode_pos">Kode Pos</label>
            <input type="number" placeholder="Kode Pos" class="form-control" id="exampleInputEmail1"
              aria-describedby="emailHelp" v-model="KartuKeluargaData.kode_pos">
          </div>
        </div>
        <button type="submit" class="btn btn-success mt-3" style="height: 40px; width: 80px;">Submit</button>
        <p v-show="cekkk" class="" style="color: red;">Nomor KK sudah terdaftar!</p>
      </form>
    </div>
  </div>



</template>

<script>
import KartuKeluargaService from '@/service/kartuservice';
import SuccessForm from './SuccessForm.vue';

export default {
  components: {
    SuccessForm,
  },
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
      SuccessForm: false,
      cekkk: false,
    };
  },

  methods: {
    inputKartuKeluarga() {
      let data = this.KartuKeluargaData;

      KartuKeluargaService
        .create(data)
        .then((response) => {
          console.log(response.data);
          this.SuccessForm = true
        })
        // this.SuccessForm = true
        .catch((e) => {
          if (e.response.data.trace.includes("Duplicate entry")) {
            this.cekkk = true
          }
        })
    },
  },
};
</script>

<style scoped>
form {
  width: 77%;
  height: 96%;
  margin-left: 120px;
  margin-top: 150px;
}

.kodepos {
  margin-left: 51%;
}
</style>