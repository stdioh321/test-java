<%@ attribute name="id" required="true" %>

<input type="text" id="<%=id%>" class="form-control" placeholder="Birthdate" />
<script>
	$("#dateField").datepicker();
</script>