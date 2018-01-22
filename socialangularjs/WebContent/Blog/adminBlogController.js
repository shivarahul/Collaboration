app.controller("adminBlogController", function($scope, $http, $location) {
	$scope.blog={blogId:0,blogName:'',blogContent:'',createDate:'',likes:0,username:'',status:'A'};
	$scope.blogdata;

	
	function fetchAllApproveBlog() {
		console.log("fetching all Admin Blogs");
		$http.get("http://localhost:8181/Collabaration/getAllBlogs")

		.then(function(response) {
			$scope.approveblogdata = response.data;
			console.log("data fetched from Admin blog");
		});

	};
	
	
	/*fetchAllApproveBlog();
	$scope.incrementLike=function(blogId)
	{
		console.log('Entering Increment Like');
		$http.get('http://localhost:8181/Collabaration/incLike/'+blogId)
		.success(fetchAllApproveBlog(),function(response)
				{
				console.log('Blog Like Incremented');
				$location.path("/Blog");
				});
	}*/
	
   fetchAllApproveBlog();
	$scope.approveBlog=function(blogId) 
	{
		console.log("entered in approve blog");
		$http.get('http://localhost:8181/Collabaration/approveBlog/'+ blogId)
				.then(fetchAllApproveBlog(), 
						function(response) 
		{
			console.log("Blog is approved");
		})
	}
	
	
	
	$scope.rejectBlog=function(blogId)
	{
	$http.get('http://localhost:8181/Collabaration/rejectBlog/'+blogId)
	.then(fetchAllBlog(),function(response){
		console.log('blog rejected');
	})
	}
});