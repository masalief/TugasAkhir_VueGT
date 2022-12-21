<template>
    <div>
        <div class="background">
            <div class="shape"></div>
            <img src="../assets/ktp.png" alt="ktp">
            <div class="shape"></div>
        </div>
        <form @submit.prevent="loginFunc">

            <h3>Selamat Datang!</h3>

            <div>
                <label for="username">Email</label>
                <input type="email" placeholder="Email" id="username" v-model="loginData.email" required>
            </div>

            <div>
                <label for="password">Password</label>
                <input type="password" placeholder="Password" id="password" v-model="loginData.password" required>
            </div>
            <p v-show="message" style="color:red;"><b>Email atau Password salah!</b></p>

            <div class="formlogin">
                <button type="submit" class="btn btn-success ">Login</button>
            </div>

            <div class="social">
                <p>Belum punya akun?</p><router-link to="/register">Daftar disini</router-link>
            </div>
        </form>
    </div>

</template>

<script>
import serviceUsers from '@/service/userservice';

export default {

    name: "LoginComponent",

    data() {
        return {
            loginData: {
                email: null,
                password: null,
            },
            message: false,
        }
    },

    methods: {
        loginFunc() {
            let data = this.loginData;
            console.log(data)
            serviceUsers.userLogin(data).then(response => {
                console.log(response);
                this.$router.push("/home");
            }).catch((e) => {
                if (e.response.data.trace.includes("Incorrect result")) {
                    this.message = true
                }
            });
        }
    },
};
</script>

<style>
.formlogin {
    margin-top: 25px;
}

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
    height: 520px;
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

/* .shape:first-child{
    background: linear-gradient(
        #012781,
        #111518
    );
    left: -80px;
    top: -80px;
}
.shape:last-child{
    background: linear-gradient(
        to right,
        #ff512f,
        #f09819
    );
    right: -30px;
    bottom: -80px;
} */
form {
    height: 520px;
    width: 400px;
    background-color: rgba(2, 2, 2, 0.13);
    position: absolute;
    transform: translate(-50%, -50%);
    top: 50%;
    left: 50%;
    border-radius: 10px;
    backdrop-filter: blur(2px);
    border: 2px solid rgba(15, 10, 10, 0.1);
    box-shadow: 0 0 40px rgba(83, 94, 92, 0.6);
    padding: 50px 35px;
}

form * {
    font-family: 'Poppins', sans-serif;
    color: #7d0202;
    letter-spacing: 0.5px;
    outline: none;
    border: none;
}

form h3 {
    font-size: 35px;
    font-weight: 100;
    line-height: 42px;
    text-align: center;
}

label {
    display: block;
    margin-top: 20px;
    font-size: 16px;
    font-weight: 500;
}

input {
    display: block;
    height: 50px;
    width: 100%;
    background-color: rgba(7, 7, 7, 0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-top: 8px;
    font-size: 14px;
    font-weight: 300;
}

::placeholder {
    color: #7d0202;
}

button {
    margin-top: 60px;
    width: 100%;
    background-color: #0769e1;
    color: #ffffff;
    padding: 10px 0;
    font-size: 20px;
    font-weight: 100;
    border-radius: 10px;
    cursor: pointer;
}

.social {
    margin-top: 20px;
    text-align: center;
    font-size: 13px;
    text-decoration: none;
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
</style>