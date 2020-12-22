<!DOCTYPE html>
<html lang="en">

<head>


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add User</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.0/axios.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/vue-moment@4.1.0/dist/vue-moment.min.js"></script>
</head>

<body>
	<div id="app">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h2>Add User Form</h2>
				</div>
				<div class="col-12">{{ fData }}</div>
			</div>
			<div class="row">
				<div class="col-12">
					<form action="" class="form" @submit="checkForm">
						<div class="form-group row">
							<label class="col-12 col-form-label">Name</label>
							<div class="col-12">
								<input type="text" class="form-control" placeholder="Name..."
									v-model="fData.name"
									v-bind:class="[fData.name ? 'is-valid' : 'is-invalid']">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-6 offset-6">
								<button type="submit" class="btn btn-block btn-primary"
									:disabled="!fData.name || loading">
									<span v-if="!loading">Send</span> <span v-else>Loading...</span>
								</button>
							</div>
							<div class="col-6"></div>
						</div>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="row">

						<div class="col-6"
							v-for="user in users" :key="user.id">
						<li class="list-group-item">
							
							<div class="d-flex justify-content-between">
								<div class="flex-fill d-flex align-items-center">{{user.name}}</div>
								<div class="text-danger  d-flex align-items-center">
									{{user.createdAt | moment("YYYY-MM-DD, HH:mm:ss a")}}</div>
								<div class="align-items-center d-flex">
									<button class="btn bg-transparent" @click="onDeleteUser(user)">
										<i class="fa fa-trash text-danger" aria-hidden="true"></i>

									</button>
								</div>
							</div>
							</li>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
    Vue.use(vueMoment);
        var app = new Vue({
            el: "#app",
            data: {
                msg: "Hello",
                fData: {
                    name: null
                },
                loading:false,
                users: []
            },
            methods: {
            	onDeleteUser: function(user){
            		
            		
            		axios.delete("rest/user/"+user.id)
            		.then(res=>{
            			console.log(res);
            			this.users.splice(this.users.indexOf(user), 1);
            		})
            		.catch(err=>{
            			console.log(err);
            		});
            	},
                checkForm: function(e) {
                    e.preventDefault();
                    if(this.loading) return;
                    this.loading = true;
                    if (!this.fData.name) return false;
                    console.log("FORM OK");
                    axios.post("rest/user",
                            this.fData)
                        .then(res => {
                            console.log(res);
                            if(res.status != 200) throw "Error";
                            this.users.push(res.data);
                            this.loading =false;
                            this.fData = {};
                        })
                        .catch(err => {
                            console.log(err);
                            this.loading =false;
                        });
                }
            },
            mounted() {
                axios.get("rest/user")
                    .then(res => {
                        /* this.users = Array.isArray(res.data) ?  res.data : [res.data]; */
                        res.data.forEach(e=>{
                        	this.users.unshift(e);
                        	
                        });
                         
                        console.log(this.users);

                    })
                    .catch(err => {
                        console.log(err);
                    });
            }
        });
    </script>
</body>

</html>