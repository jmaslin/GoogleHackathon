<?php include "views/header.php"; ?>

	<div class="container-fluid">

		<div id="top" class="row-fluid text-center">
			<div class="col-sm-6 col-sm-offset-3">
				<h1>Overlord App <small>Connecting people the smart way.</small></h1>
				<hr />
			</div>
		</div>

		<div class="row-fluid text-center">
			<div class="col-sm-6 col-sm-offset-3">
				<h2>Choose some options.</h2>
				<br />
				<!-- TODO: LOG IN BUTTON -->

					<!-- Request: Either buying or selling. What it is. Location. Email or phone, but have one. -->

					<!-- Field One: WANT / NEED -->
					<!-- Field Two: ITEM / SERVICE -->
					<!-- Field Three: Must choose AT LEAST one: -->
						<!-- Field Three: EMAIL (Optional) -->
						<!-- Field Three Part Two: PHONE (Optional) -->
					<!-- FIELD Four: PASSWORD (Optional, used to make account to manage requests.) -->

					<form id="submitReq" role="form" action="process/run.jsp">

						<div class="form-group">
							<label for="purpose">Purpose</label>
							<div class="radio">
								<label>
									<input type="radio" name="purposeRadio" id="purpose1" value="1">
									I want
								</label>
								<label>
									<input type="radio" name="purposeRadio" id="purpose2" value="2">
									I have
								</label>
						</div>
						<div class="form-group">
							<label for="request">Request</label>
							<input type="text" class="form-control" name="requestType" id="requestType" autocomplete="off" placeholder="Enter what you have or need.">
						</div>
						<div class="form-group">
							<label for="location">Location</label>
							<input type="text" class="form-control" name="location" id="location" autocomplete="off" placeholder="Enter your general location.">
						</div>
						<label for="contact">Contact Method(s)</label>
						<div class="input-group">
							<span class="input-group-addon">
								<input id="emailCheck" type="checkbox">
							</span>
							<input type="text" class="form-control" name="contactEmail" id="contactEmail" autocomplete="off" placeholder="Email">
						</div>
						<div class="input-group">
							<span class="input-group-addon">
								<input id="phoneCheck" type="checkbox">
							</span>
							<input type="text" class="form-control" name="contactPhone" id="contactPhone" autocomplete="off" placeholder="Phone">
						</div>
						<!-- TODO: Make this better. All of it. -->
						<br />
						<div class="form-group">
							<label for="request">Password (Optional, create an account to manage requests.)</label>
							<input type="password" class="form-control" name="password" id="password" placeholder="Password">
							<!-- TODO: Hide this until someone types in above field. -->
							<input type="password" class="form-control" name="passwordConf" id="passwordConf" placeholder="Password Confirm">						
						</div>
     	  		<button id="submitRequest" type="submit" class="btn btn-default">Submit</button>
     			</form>

			</div>
		</div>

	</div>

	<script type="text/javascript">

		$('#submitRequest').on("click", function(e) {
			e.preventDefault(); // Got to error validates the datas firsts

			if (validateInput()) {
				submitToJSON(); // Now our Java friends can do stuff
			}

		});


		function validateInput() {
			// Limited error checking because will be checked in backend.

			if (validateRequest()) {
				if ($('#emailCheck').attr('checked')) {
					validateEmail();
				}
			}



			return false;
		}

		// TODO: Dropdown/Suggestions from common requests.
		function validateRequest() {

			validateRequest = false;

			request = $('#requestType').val();

			if (request != "") {
				validateRequest = true;
			}
		}

		function submitToJSON() {

			$.ajax({
				type: "POST", 
				url: "process/test.php", 
				data: $('#submitReq').serialize(), 
				dataType: "json", 
				success: function(data) {

				}

			});
		}

	</script>

<?php include "views/footer.php"; ?>
