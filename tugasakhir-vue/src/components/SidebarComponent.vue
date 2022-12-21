<template>
    <div>
        <div class="sidebar">
            <header>E-KTP APP</header>
            <ul>
                <li><router-link to="/home" class="">Home</router-link></li>
                <li><router-link to="/addkk" class="">Tambah KK</router-link></li>
                <li><router-link to="/" class="">Logout</router-link></li>
            </ul>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style>
body {
    font-family: 'Roboto', sans-serif;
}

* {
    margin: 0;
    padding: 0;
    list-style: none;
    text-decoration: none;
}

.sidebar {
    position: fixed;
    left: 0;
    width: 220px;
    height: 100%;
    background: rgb(20, 67, 100);
}

.sidebar header {
    font-size: 30px;
    color: rgb(20, 67, 100);
    text-align: center;
    line-height: 70px;
    background: rgb(255, 173, 73);
    user-select: none;
}

.sidebar ul a {
    display: block;
    height: 100%;
    width: 100%;
    line-height: 65px;
    font-size: 15px;
    color: rgb(255, 255, 255);
    padding-left: 20px;
    box-sizing: border-box;
    border-top: 1px solid rgba(255, 255, 255, .1);
    border-bottom: 1px solid rgb(255, 173, 73);
    transition: .4s;
    text-decoration: none;
}

ul li:hover a {
    padding-left: 40px;
}

.sidebar ul a i {
    margin-right: 20px;
}
</style>