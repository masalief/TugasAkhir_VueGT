import http from "../http-common";

class AnggotaKeluargaService {
  create(data) {
    return http.post("/anggotakeluarga/insert", data);
  }

  getAllAnggotaKeluarga() {
    return http.get("/anggotakeluarga/getAll");
  }

  deleteAnggotaKeluarga(id) {
    return http.delete(`/anggotakeluarga/delete/${id}`);
  }

  updateAnggotaKeluarga(id, data) {
    return http.put(`/anggotakeluarga/update/${id}`, data);
  }

  getAnggotaKeluarga(id) {
    return http.get(`/anggotakeluarga/getAnggotaKeluarga/${id}`);
  }
  getAnggotaById(id) {
    return http.get(`/anggotakeluarga/getAnggotaById/${id}`);
  }
}

export default new AnggotaKeluargaService();