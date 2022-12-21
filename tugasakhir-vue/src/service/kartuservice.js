import http from "../http-common";

class KartuKeluargaService {
  create(data) {
    // console.log(data)
    return http.post("/kartukeluarga/insert", data);
  }

  getAllKartuKeluarga() {
    return http.get("/kartukeluarga/getAll");
  }

  deleteKartuKeluarga(id) {
    return http.delete(`/kartukeluarga/delete/${id}`);
  }

  updateKartuKeluarga(id, data) {
    return http.put(`/kartukeluarga/update/${id}`, data);
  }

  getKartuById(id) {
    return http.get(`/kartukeluarga/getKartuById/${id}`);
  }
}

export default new KartuKeluargaService();