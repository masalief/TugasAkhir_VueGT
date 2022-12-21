import LoginPage from "./pages/Login.vue";
import HomePage from "./pages/Home.vue";
import RegisterPage from "./pages/Register.vue";
import Tambahkk from "./pages/Tambahkk.vue";
import Detailkk from "./pages/Detailkk.vue";
import DaftarAnggota from "./pages/DaftarAnggota.vue";
import TambahAnggota from "./pages/TambahAnggota.vue";
import DetailAnggota from "./pages/DetailAnggota.vue";

export default [
    {
        path: "/",
        component: LoginPage,
    },

    {
        path: "/home",
        component: HomePage,
    },
    {
        path: "/register",
        component: RegisterPage,
    },
    {
        path: "/addkk",
        component: Tambahkk,
    },
    {
        path: "/detailkk/:id",
        component: Detailkk,
    },
    {
        path: "/listanggota/:id",
        component: DaftarAnggota,
    },
    {
        path: "/tambahanggota/:id",
        component: TambahAnggota,
    },
    {
        path: "/detailanggota/:id",
        component: DetailAnggota,
    },

];