<template>
  <div style="width: inherit">
    <div>
      <nav class="ml-5 mt-3 mb-5">
        <h3>Home Page</h3>
      </nav>
    </div>

    <div class="row ml-5">

      <div class="card bg-dark" style="max-width: 18rem;">
        <div class="card-header bg-info text-warning">Jumlah Kartu Keluarga</div>
        <div class="card-body">
          <p class="card-text text-light bg-dark">{{ KartuKeluargaData.length }}</p>
        </div>
      </div>

      <div class="card bg-dark ml-3" style="max-width: 18rem;">
        <div class="card-header bg-info text-warning">Jumlah Seluruh Warga</div>
        <div class="card-body">
          <p class="card-text text-light bg-dark">{{ AnggotaKeluargaData.length }}</p>
        </div>
      </div>

    </div>

    <div class="ml-5">
      <div class="my-5 ml-4">
        <h2 class="text-center my4">Data Kartu Keluarga</h2>
      </div>

      <table class="table ml-4">
        <thead>
          <tr class="bg-lightgrey">
            <th scope="col">No</th>
            <th scope="col">Nomor KK</th>
            <th scope="col">Alamat</th>
            <th scope="col">Kota</th>
            <th scope="col">Kode Pos</th>
            <th scope="col">Action</th>
          </tr>
          <tr>
            <td colspan="6" class="text-center" v-if="KartuKeluargaData.length == 0">Tidak ada Data</td>
          </tr>
          <tr v-for="(item, index) in KartuKeluargaData" :key="index">
            <th scope="col">{{ index += 1 }}</th>
            <th scope="col">{{ item.nomor_kk }}</th>
            <th scope="col">{{ item.alamat + "," + item.desa_kelurahan + "," + item.kecamatan }}</th>
            <th scope="col">{{ item.kabupaten_kota }}</th>
            <th scope="col">{{ item.kode_pos }}</th>
            <div class="d-flex mt-1 ml-2">
              <router-link :to="{ path: '/detailkk/' + item.id }"><button type="button"
                  class="btn btn-warning mr-1 mb-1 mt-1" style="width:70px; height:38px;">Detail</button></router-link>
              <button type="button" class="btn btn-danger ml-1 mb-1 mt-1"
                @click="deleteKartuKeluargaFunction(item.id, item.nomor_kk)"
                style="width:70px; height:38px;">Delete</button>
            </div>
          </tr>
        </thead>
      </table>
    </div>
  </div>
</template>

<script>
import KartuKeluargaService from '@/service/kartuservice';
import AnggotaKeluargaService from '@/service/anggotaservice';

export default {

  name: "HomePage",

  data() {
    return {
      KartuKeluargaData: [],
      AnggotaKeluargaData: [],
      success: false,
    };
  },
  mounted() {
    this.getKartuKeluarga();
  },
  methods: {
    getKartuKeluarga() {
      KartuKeluargaService.getAllKartuKeluarga()
        .then((response) => {
          this.KartuKeluargaData = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },

    getAllAnggotaKeluarga() {
      AnggotaKeluargaService.getAllAnggotaKeluarga()
        .then((response) => {
          this.AnggotaKeluargaData = response.data;
        })
        .catch((e) => {
          console.log(e);
        })
    },
    deleteKartuKeluargaFunction(id, nomor_kk) {
      if (confirm(`Anda akan menghapus data KK ${nomor_kk} berserta anggotanya!`)) {
        KartuKeluargaService.deleteKartuKeluarga(id)
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