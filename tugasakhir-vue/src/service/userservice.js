import http from "../http-common";

class UserService {
  create(data) {
    return http.post("user/insert", data);
  }

  getAllUser() {
    return http.get("user/getAll");
  }

  deleteUser(id) {
    return http.deleteUser(`user/delete/${id}`);
  }

  updateUser(id, data) {
    return http.put(`user/update/${id}`, data);
  }

  userLogin(data) {
    return http.post("user/login", data);
  }

}

export default new UserService();