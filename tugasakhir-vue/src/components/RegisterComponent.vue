<template>
    <div>
        <div class="background">
            <div class="shape"></div>
            <img src="../assets/ktp.png" alt="ktp">
            <div class="shape"></div>
        </div>
        <form @submit.prevent="register">

            <h3>Daftar Disini</h3>

            <div>
                <label for="username">Nama Lengkap</label>
                <input type="text" placeholder="Nama" id="username" v-model="dataRegistrasi.nama" required>
            </div>

            <div>
                <label for="username">Email</label>
                <input type="email" placeholder="Email" id="email" v-model="dataRegistrasi.email" required>
            </div>

            <div>
                <label for="username">Password</label>
                <input type="password" placeholder="Password" id="password" v-model="dataRegistrasi.password" required>
            </div>

            <div>
                <label for="password">Re Password</label>
                <input type="password" placeholder="Re Password" id="repassword" v-model="password2" required>
            </div>

            <p v-if="registerSuccess">Berhasil Daftar!, Silahkan Login</p>
            <p v-if="emailValid">Email sudah di gunakan!</p>
            <p v-if="passwordValid">Password tidak sama</p>

            <div class="daftar">
                <button type="submit" class="btn btn-primary mt-3 mr-1"
                    style="height: 38px; width: 70px;">Daftar</button>
                <router-link to="/"><button type="button" class="btn btn-success mt-3"
                        style="height: 38px; width: 70px;">Login</button></router-link>
            </div>
        </form>
    </div>

</template>
    
<script>
import serviceUsers from '@/service/userservice';
export default {
    name: 'RegisterComponents',

    data() {
        return {
            dataRegistrasi: {
                nama: null,
                email: null,
                password: null
            },
            password2: "",
            registerSuccess: false,
            emailValid: false,
            passwordValid: false
        }
    },

    methods: {

        register() {
            let data = this.dataRegistrasi;
            let password1 = data.password;
            let password2 = this.password2;

            this.registerSuccess = false;
            this.emailValid = false;
            this.passwordValid = false;

            if (password1 == password2) {
                console.log(data);
                serviceUsers.create(data).then(response => {
                    console.log(response);
                    this.dataRegister = {};
                    this.password2 = "";
                    this.registerSuccess = true;
                    // l
                }).catch(e => {
                    console.log(e);
                    if (e.response.data.status === 500) {

                        this.emailValid = true;
                    }
                })
            } else {
                // location.reload();
                this.passwordValid = true;
            }
        }
    }
};
</script>
    
<style>
*:before,
*:after {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}

body {
    background-color: #080710;
}

.background {
    width: 430px;
    height: 600px;
    position: absolute;
    transform: translate(-50%, -50%);
    left: 50%;
    top: 50%;
}

.background .shape {
    height: 200px;
    width: 200px;
    position: absolute;
    border-radius: 50%;
}

.shape:first-child {
    background: linear-gradient(#0743d1,
            #23a2f6);
    right: -100px;
    /* left: -100px; */
    top: 85%;
}

.shape:last-child {
    background: linear-gradient(to right,
            #ff512f,
            #f09819);
    /* right: -100px; */
    left: -100px;
    bottom: 500px;
}

form {
    height: 750px;
    width: 500px;
    background-color: rgba(2, 2, 2, 0.13);
    position: absolute;
    transform: translate(-50%, -50%);
    top: 50%;
    left: 50%;
    border-radius: 30px;
    backdrop-filter: blur(0.5px);
    border: 2px solid rgba(97, 97, 97, 0.1);
    box-shadow: 0 0 40px rgba(1, 1, 1, 0.6);
    padding: 50px 35px;
}

form * {
    font-family: 'Poppins', sans-serif;
    color: #000000;
    letter-spacing: 0.5px;
    outline: none;
    border: none;
}

form h3 {
    font-size: 35px;
    font-weight: 500;
    line-height: 42px;
    text-align: center;
}

label {
    display: block;
    margin-top: 30px;
    font-size: 16px;
    font-weight: 500;
}

input {
    display: block;
    height: 50px;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-top: 8px;
    font-size: 14px;
    font-weight: 300;
}

::placeholder {
    color: #000000;
}

button {
    margin-top: 60px;
    width: 100%;
    background-color: #0769e1;
    color: #ffffff;
    padding: 15px 0;
    font-size: 18px;
    font-weight: 600;
    border-radius: 5px;
    cursor: pointer;
}

.social {
    margin-top: 40px;
    text-align: center;
    font-size: 13px;
}

.social div {
    background: red;
    width: 150px;
    border-radius: 3px;
    padding: 5px 10px 10px 5px;
    background-color: rgba(255, 255, 255, 0.27);
    color: #000000;
    text-align: center;
}

.social div:hover {
    background-color: rgba(141, 5, 5, 0.47);
}

.social .fb {
    margin-left: 25px;
}

.social i {
    margin-right: 4px;
}
</style>