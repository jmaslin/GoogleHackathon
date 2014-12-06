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
									<input type="radio" name="purposeRadio" id="purpose1">
									I want
								</label>
								<label>
									<input type="radio" name="purposeRadio" id="purpose2">
									I have
								</label>
						</div>
						<div class="form-group">
							<label for="request">Request</label>
							<input type="text" class="form-control" id="requestType" placeholder="Enter what you want or need">
						</div>
						<label for="contact">Contact Method(s)</label>
						<div class="input-group">
							<span class="input-group-addon">
								<input type="checkbox">
							</span>
							<input type="text" class="form-control" id="contactEmail" placeholder="Email">
						</div>
						<div class="input-group">
							<span class="input-group-addon">
								<input type="checkbox">
							</span>
							<input type="text" class="form-control" id="contactPhone" placeholder="Phone">
						</div>
						<!-- TODO: Make this better. All of it. -->
						<br />
						<div class="form-group">
							<label for="request">Password (Optional, create an account to manage requests.)</label>
							<input type="password" class="form-control" id="password" placeholder="Password">
							<!-- TODO: Hide this until someone types in above field. -->
							<input type="password" class="form-control" id="passwordConf" placeholder="Password Confirm">						
						</div>
					</form>

			</div>
		</div>

	</div>

<?php include "views/footer.php"; ?>
