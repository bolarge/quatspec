<%@ include file="/WEB-INF/tags.jsp"%>
<!-- Tasks -->
<!-- Update all images link to correct link -->


<!--Display -->
	<div class="col-sm-10">
		<div class="custom-container">
			<div class="card no-border-radius">
				<div class="card-body">
					<div class="tab-content" id="custom-navbar">
						<div class="tab-pane fade main-tabpane show active " id="overview"
							role="tabpanel" aria-labelledby="pills-home-tab">
							<div class="col-sm-12">
								<div class="row row-space">
									<div class="col-sm-5">
										<div class="card no-card-border card-height">
											<div class="card-body nopadding po-offer">
												<div class="row">
													<div class="col-sm-10">
														<h6 class="text-muted">Ongoing Public Offer</h6>
													</div>
													<div class="col-sm-2">
														<h5>4</h5>
													</div>
												</div>
												<ul class="list-unstyled">
													<li class="media"><img class="mr-3 list-img"
                                                                           src="<c:url value='/static/images/mtn.png' />" alt="Generic placeholder image" />
														<div class="media-body">
															<h6 class="mt-0 mb-1">MTN Nigeria</h6>
														</div></li>
													<li class="media my-4"><img class="mr-3 list-img"
                                                                                src="<c:url value='/static/images/fg.png' />" alt="Generic placeholder image" />
														<div class="media-body">
															<h6 class="mt-0 mb-1">Federal Govt. Savings Bond</h6>
														</div></li>
													<li class="media"><img class="mr-3 list-img"
                                                                           src="<c:url value='/static/images/uac.png' />" alt="Generic placeholder image" />
														<div class="media-body">
															<h6 class="mt-0 mb-1">UAC Nigeria</h6>
														</div></li>
													<li class="media my-4"><img class="mr-3 list-img"
                                                                                src="<c:url value='/static/images/diamond.png' />" alt="Generic placeholder image" />
														<div class="media-body">
															<h6 class="mt-0 mb-1">Diamond Bank</h6>
														</div></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="col-sm-7">
										<div class="card no-card-border card-height">
											<div class="card-body nopadding po-offer">
												<div class="row">
													<div class="col-sm-10">
														<h6 class="text-muted">Subscribers</h6>
													</div>
													<div class="col-sm-2">
														<h5>23,751</h5>
													</div>
												</div>
												<div class="row row-pad">
													<div class="col-sm-4 mychart"></div>
													<div class="col-sm-8">
														<div class="row row-pad">
															<div class="col-sm-8">
																<li class="mtnlist"><span class="black-color">MTN
																		Nigeria</span></li>
																<li class="fglist"><span class="black-color">Federal
																		Govt. Savings Bond</span></li>
																<li class="uaclist"><span class="black-color">UAC
																		Nigeria</span></li>
																<li class="dialist"><span class="black-color">Diamond
																		Bank</span></li>
															</div>
															<div class="col-sm-4 text-right">
																<p class="percentages">31%</p>
																<p class="percentages">15%</p>
																<p class="percentages">28%</p>
																<p class="percentages">26%</p>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="row row-space">
									<div class="col-sm-8">
										<div class="card no-card-border card-height-1">
											<div class="card-body nopadding po-offer">
												<div class="row">
													<div class="col-sm-12">
														<h6 class="text-muted">
															Payment Methods<i
																class="fa fa-credit-card-alt iconleftpad"></i>
														</h6>
														<div class="bar-chart"></div>
													</div>
												</div>

											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="card no-card-border card-height-1">
											<div class="card-body nopadding po-offer">
												<div class="row">
													<div class="col-sm-12">
														<h7 class="text-muted">Value Alloted<i
															class="fa fa-shopping-bag float-right" aria-hidden="true"></i></h7>
														<h3 class="padding-bottom-1">N110,470,500</h3>
														<h7 class="text-muted row-space">Pending Allotment
														Value</h7>
														<h3>N110,470,500</h3>
													</div>
												</div>

											</div>
										</div>
									</div>
								</div>


								<div class="row row-space">
									<div class="col-sm-5">
										<div class="card no-card-border">
											<div class="card-body nopadding po-offer">
												<div class="row">
													<div class="col-sm-12">
														<h7 class="text-muted">Users Online<i
															class="fa fa-laptop iconleftpad" aria-hidden="true"></i></h7>
														<h3 class="online">583</h3>
													</div>
												</div>

											</div>
										</div>
									</div>
									<div class="col-sm-7">
										<div class="card no-card-border ">
											<div class="card-body nopadding po-offer">
												<div class="row">
													<div class="col-sm-12">
														<h7 class="text-muted">Total Amount Raised<i
															class="fa fa-money iconleftpad" aria-hidden="true"></i></h7>
														<h3 class="float-right online1">N110,470,500</h3>
													</div>
												</div>

											</div>
										</div>
									</div>
								</div>
								<br /> <br />
							</div>
						</div>

						<div class="tab-pane fade main-tabpane content-height" id="offers"
							role="tabpanel" aria-labelledby="pills-home-tab">
							<div class="row row-space padding-bottom-1">
								<div class="col-sm-3">
									<button type="button"
										class="btn pobtn btn-block pobtn1 text-left"
										data-toggle="modal" data-target="#exampleModal">
										<i class="fa fa-plus iconpad"></i>Create Public Offer
									</button>
								</div>

								<div class="modal fade" id="exampleModal" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content top-border justify-content-center">
											<div class="text-center">
												<h5 class="modal-title padding-top-1" id="exampleModalLabel">New
													Public Offer</h5>
											</div>
											<div class="modal-body">
												<div class="row">
													<div class="col-sm-12">
														<p class="green-color">
															<i class="fa fa-picture-o uploadimg iconpad"
																aria-hidden="true"></i> Upload Logo(JPEG,PNG)
														</p>
													</div>
												</div>
												<div class="row padding-bottom-1">
													<div class="col-sm-12">
														<input type="text" placeholder="Name"
															class="form-control po-offer" />
													</div>
												</div>
												<div class="row padding-bottom-1">
													<div class="col-sm-12">
														<input type="text" placeholder="Symbol"
															class="form-control po-offer" />
													</div>
												</div>
												<div class="row padding-bottom-1">
													<div class="col-sm-6">
														<select class="form-control po-offer">
															<option>Asset</option>
														</select>
													</div>
													<div class="col-sm-6">
														<select class="form-control po-offer">
															<option>Offer Type</option>
														</select>
													</div>
												</div>
												<div class="row padding-bottom-1">
													<div class="col-sm-11">
														<input type="text" placeholder="Issuing House"
															class="form-control po-offer" />
													</div>

													<div class="col-sm-1 float-left">
														<i class="fa fa-plus green-color"></i>
													</div>
												</div>

												<div class="row padding-bottom-1">
													<div class="col-sm-12 input-group mb-3">
														<input type="text"
															class="form-control po-offer form-right"
															placeholder="Price" />
														<div class="input-group-append">
															<span class="input-group-text po-offer" id="basic-addon2">0.00</span>
														</div>
													</div>
												</div>

												<div class="row padding-bottom-1">
													<div class="col-sm-12 input-group mb-3">
														<input type="text"
															class="form-control po-offer form-right"
															placeholder="Number of Units" />
														<div class="input-group-append">
															<span class="input-group-text po-offer" id="basic-addon2">0</span>
														</div>
													</div>
												</div>

												<div class="row padding-bottom-1">

													<div class="col-sm-6 input-group mb-3">
														<input type="text" class="form-control po-offer"
															placeholder="Min Order" />
														<div class="input-group-append">
															<span class="input-group-text po-offer" id="basic-addon2">0</span>
														</div>
													</div>

													<div class="col-sm-6 input-group mb-3">
														<input type="text" class="form-control po-offer"
															placeholder="Max Order" />
														<div class="input-group-append">
															<span class="input-group-text po-offer" id="basic-addon2">0</span>
														</div>
													</div>

												</div>

												<div class="row padding-bottom-1">
													<div class="col-sm-6 input-group mb-3">
														<input type="text" class="form-control po-offer"
															placeholder="Start Date" />
														<div class="input-group-append">
															<span class="input-group-text po-offer" id="basic-addon2">DD/MM/YY</span>
														</div>
													</div>

													<div class="col-sm-6 input-group mb-3">
														<input type="text" class="form-control po-offer"
															placeholder="End Date" />
														<div class="input-group-append">
															<span class="input-group-text po-offer" id="basic-addon2">DD/MM/YY</span>
														</div>
													</div>
												</div>

												<div
													class="row padding-bottom-1 padding-top-1 justify-content-center">
													<div class="col-sm-5">
														<button class="btn pobtn btn-block pobtn1">
															Create Public Offer</button>
													</div>
												</div>



											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-5 offset-sm-4">
									<div class="input-group mb-3">
										<input type="text" class="form-control form-right"
											placeholder="" aria-label="Recipient's username"
											aria-describedby="basic-addon2" />
										<div class="input-group-append">
											<span class="input-group-text white-color" id="basic-addon2"><i
												class="fa fa-search"></i></span>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="row row-head-color">
									<div class="col-sm-3">
										<p>Name</p>
									</div>

									<div class="col-sm-1">
										<p>Asset</p>
									</div>

									<div class="col-sm-2">
										<p>Offer Type</p>
									</div>

									<div class="col-sm-1">
										<p>Price</p>
									</div>

									<div class="col-sm-2">
										<p>Offer Size</p>
									</div>

									<div class="col-sm-2">
										<p>Allotted</p>
									</div>

									<div class="col-sm-1">
										<p>Status</p>
									</div>
								</div>

								<div class="row padding-top-1 polist">
									<div class="col-sm-3">
										<ul class="list-unstyled">
											<li class="media"><img class="mr-3 list-img"
                                                                   src="<c:url value='/static/images/mtn.png' />" alt="Generic placeholder image" />
												<div class="media-body">
													<h7 class="mt-0 mb-1">MTN Nigeria</h7>
												</div></li>
										</ul>
									</div>

									<div class="col-sm-1">
										<p>Stock</p>
									</div>

									<div class="col-sm-2">
										<p>Initial Public Offering</p>
									</div>

									<div class="col-sm-1">
										<p>9.99</p>
									</div>

									<div class="col-sm-2">
										<p>1,000,000,000</p>
									</div>

									<div class="col-sm-2">
										<p>970,359,500</p>
									</div>

									<div class="col-sm-1">
										<p>Public</p>
									</div>
								</div>
								<hr class="customhr" />

								<div class="row padding-top-1 polist">
									<div class="col-sm-3">
										<ul class="list-unstyled">
											<li class="media"><img class="mr-3 list-img"
                                                                   src="<c:url value='/static/images/fg.png' />" alt="Generic placeholder image" />
												<div class="media-body">
													<h7 class="mt-0 mb-1">Federal Govt. Savings Bond</h7>
												</div></li>
										</ul>
									</div>

									<div class="col-sm-1">
										<p>Stock</p>
									</div>

									<div class="col-sm-2">
										<p>Initial Public Offering</p>
									</div>

									<div class="col-sm-1">
										<p>9.99</p>
									</div>

									<div class="col-sm-2">
										<p>1,000,000,000</p>
									</div>

									<div class="col-sm-2">
										<p>970,359,500</p>
									</div>

									<div class="col-sm-1">
										<p>Public</p>
									</div>
								</div>
								<hr class="customhr" />

								<div class="row padding-top-1 polist">
									<div class="col-sm-3">
										<ul class="list-unstyled">
											<li class="media"><img class="mr-3 list-img"
                                                                   src="<c:url value='/static/images/uac.png' />" alt="Generic placeholder image" />
												<div class="media-body">
													<h6 class="mt-0 mb-1">UAC Nigeria</h6>
												</div></li>
										</ul>
									</div>

									<div class="col-sm-1">
										<p>Stock</p>
									</div>

									<div class="col-sm-2">
										<p>Initial Public Offering</p>
									</div>

									<div class="col-sm-1">
										<p>9.99</p>
									</div>

									<div class="col-sm-2">
										<p>1,000,000,000</p>
									</div>

									<div class="col-sm-2">
										<p>970,359,500</p>
									</div>

									<div class="col-sm-1">
										<p>Public</p>
									</div>
								</div>
								<hr class="customhr" />

								<div class="row padding-top-1 polist">
									<div class="col-sm-3">
										<ul class="list-unstyled">
											<li class="media"><img class="mr-3 list-img"
                                                                   src="<c:url value='/static/images/diamond.png' />" alt="Generic placeholder image" />
												<div class="media-body">
													<h6 class="mt-0 mb-1">Diamond Bank</h6>
												</div></li>
										</ul>
									</div>

									<div class="col-sm-1">
										<p>Stock</p>
									</div>

									<div class="col-sm-2">
										<p>Initial Public Offering</p>
									</div>

									<div class="col-sm-1">
										<p>9.99</p>
									</div>

									<div class="col-sm-2">
										<p>1,000,000,000</p>
									</div>

									<div class="col-sm-2">
										<p>970,359,500</p>
									</div>

									<div class="col-sm-1">
										<p>Public</p>
									</div>
								</div>
								<hr class="customhr" />
							</div>
						</div>

						<!-- User Menu -->
						<div class="tab-pane fade main-tabpane content-height" id="users"
							role="tabpanel" aria-labelledby="pills-home-tab">
							<div class="row">
								<div class="col-sm-3">
									<button
										class="btn report-btn float-right btn-block no-border-radius"
										data-toggle="modal" data-target="#newuser">
										<i class="fa fa-plus iconpad" aria-hidden="true"></i>Create
										New User
									</button>
								</div>
								<div class="col-sm-9 d-flex justify-content-end">
									<div class="col-sm-6">
										<div class="input-group mb-3">
											<input type="text" placeholder="Search..."
												class="form-control form-right no-border-radius formcolor" />
											<div class="input-group-append">
												<span class="input-group-text formcolor no-border-radius"
													id="basic-addon2"><i class="fa fa-search iconpad "
													aria-hidden="true"></i></span>
											</div>
										</div>
									</div>
								</div>

								<!-- User Form -->
								<div class="modal fade" id="newuser" tabindex="-1" role="dialog"
									aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content top-border justify-content-center">
											<div class="text-center">
												<h5 class="modal-title padding-top-1" id="exampleModalLabel">New
													Institution</h5>
											</div>
											<div class="modal-body">
												<div class="row">
													<div class="col-sm-12">
														<p class="green-color">
															<i class="fa fa-picture-o uploadimg iconpad"
																aria-hidden="true"></i> Upload Logo(JPEG,PNG)
														</p>
													</div>
												</div>
												
												<!-- Upgrade Form to Spring Form -->
												<form:form modelAttribute="stakeholder" id="app_stakeholder" method="post" action="<c:url value='/stakeholder'/> ">

													<c:if test="${not empty message}">
														<div id="message" class="${message.type}">${message.message}</div>
													</c:if>
												<div class="row padding-bottom-1">
													<div class="col-sm-12">
														<input type="text" placeholder="Business Name" name="stakeHolderName" id="stakeHolderName"
															class="form-control po-offer" />
													</div>
												</div>
												<div class="row padding-bottom-1">
													<div class="col-sm-12">
														<input type="text" placeholder="Institution" name="businessName" id="businessName"
															class="form-control po-offer" />
													</div>
												</div>
												
												<div class="row padding-bottom-1">
													<div class="col-sm-12">
														<form:select path="profiles" items="${userprofiles1}"  class="form-control po-offer" multiple="false" 
														itemValue="name" itemLabel="description" >														
														</form:select>
													</div>
												</div>
											
												<div class="row padding-bottom-1">
													<div class="col-sm-12">
														<input type="text" placeholder="business email" name="businessEmail" id="businessEmail"
															class="form-control po-offer" />
													</div>
												</div>

												<div class="row padding-bottom-1">
													<div class="col-sm-12">
														<input type="text" placeholder="Business Phone Number" name="businessTelephone" id="businessTelephone"
															class="form-control po-offer" />
													</div>
												</div>

												<div
													class="row padding-bottom-1 padding-top-1 justify-content-center">
													<div class="col-sm-5">
														<button class="btn pobtn btn-block pobtn1">Add
															Institution</button>
													</div>
												</div>
											</form:form>

											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col-sm-12">
								<div class="row row-head-color text-center">
									<div class="col-sm-4">
										<p>Company</p>
									</div>

									<div class="col-sm-4">
										<p>Institution</p>
									</div>

									<div class="col-sm-4">
										<p>Users</p>
									</div>
								</div>

								<div class="row text-center padding-top-1">
									<div class="col-sm-4">
										<div class="row">
											<div class="col-sm-2"> 
												<img class="manageusers" src="<c:url value='/static/images/afri.png' />" />
											</div>

											<div class="col-sm-8">
												<a data-toggle="collapse" data-parent="#exampleAccordion"
													href="#exampleAccordion1" role="button"
													aria-expanded="true" aria-controls="exampleAccordion1">African
													Prudential Registrars</a>
											</div>
										</div>
									</div>

									<div class="col-sm-4">
										<p>Registrar</p>
									</div>

									<div class="col-sm-4">
										<p>4</p>
									</div>
								</div>
								<div id="exampleAccordion1" class="row collapse" role="tabpanel">
									<div class="row text-center">
										<div class="col-sm-4">
											<p class="mtd accordionheading mb-2">Name</p>
											<p class="mtd mb-1">Chike Amara</p>
											<p class="mtd mb-1">Chike Amara</p>
											<p class="mtd mb-1">Chike Amara</p>
										</div>

										<div class="col-sm-4">
											<p class="mtd accordionheading mb-2">Role</p>
											<p class="mtd mb-1">User</p>
											<p class="mtd mb-1">User</p>
											<p class="mtd mb-1">Admin</p>

										</div>

										<div class="col-sm-4">
											<p class="mtd accordionheading mb-2">email address</p>
											<p class="mtd mb-1">chike.amara@fbn.com</p>
											<p class="mtd mb-1">chike.amara@fbn.com</p>
											<p class="mtd mb-1">chike.amara@fbn.com</p>
											<br />
										</div>
									</div>
								</div>
								<hr class="customhr" />
								<div class="row text-center padding-top-1">
									<div class="col-sm-4">
										<div class="row">
											<div class="col-sm-2"> 
												<img class="manageusers" src="<c:url value='/static/images/afri.png' />" />
											</div>

											<div class="col-sm-8">
												<p>African Prudential Registrars</p>
											</div>
										</div>
									</div>

									<div class="col-sm-4">
										<p>Registrar</p>
									</div>

									<div class="col-sm-4">
										<p>4</p>
									</div>
								</div>
								<hr class="customhr" />
								<div class="row text-center padding-top-1">
									<div class="col-sm-4">
										<div class="row">
											<div class="col-sm-2">
												<img class="manageusers" src="<c:url value='/static/images/afri.png' />" />
											</div>

											<div class="col-sm-8">
												<p>African Prudential Registrars</p>
											</div>
										</div>
									</div>

									<div class="col-sm-4">
										<p>Registrar</p>
									</div>

									<div class="col-sm-4">
										<p>4</p>
									</div>
								</div>
								<hr class="customhr" />
								<div class="row text-center padding-top-1">
									<div class="col-sm-4">
										<div class="row">
											<div class="col-sm-2">
												<img class="manageusers" src="<c:url value='/static/images/diamond.png' />" />
											</div>

											<div class="col-sm-8">
												<p>African Prudential Registrars</p>
											</div>
										</div>
									</div>

									<div class="col-sm-4">
										<p>Registrar</p>
									</div>

									<div class="col-sm-4">
										<p>4</p>
									</div>
								</div>
								<hr class="customhr" />
							</div>
						</div>


						<div class="tab-pane fade main-tabpane content-height"
							id="payments" role="tabpanel" aria-labelledby="pills-home-tab">
							<div class="row">
								<div class="col-sm-3">
									<button
										class="btn report-btn float-right btn-block no-border-radius"
										data-toggle="modal" data-target="#newuser">
										<i class="fa fa-plus iconpad" aria-hidden="true"></i>Add
										Payment Method
									</button>
								</div>
								<div class="col-sm-9 d-flex justify-content-center">
									<div class="col-sm-6">
										<p>Payment Methods</p>
									</div>
								</div>
							</div>

							<div class="row">

								<div class="col-sm-4 padding-top-1">
									<div class="payments-section padding-1">
										<div class="row ">
											<div class="col-sm-6">
												<p>
													<i class="fa fa-money iconpad" aria-hidden="true"></i> Cash
												</p>
											</div>
											<div class="col-sm-6">
												<i class="fa fa-ellipsis-v float-right" aria-hidden="true"></i>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-12">
												<p class="caption_payment">Cash deposits to Bank or
													Brokerage</p>
											</div>
										</div>
									</div>
								</div>


								<div class="col-sm-4 padding-top-1">
									<div class="payments-section padding-1">
										<div class="row ">
											<div class="col-sm-6">
												<p>
													<i class="fa fa-university" aria-hidden="true"></i> Bank
													Transfer
												</p>
											</div>
											<div class="col-sm-6">
												<i class="fa fa-ellipsis-v float-right" aria-hidden="true"></i>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-12">
												<p class="caption_payment">Account to account transfer
													processed by NIBSS</p>
											</div>
										</div>
									</div>
								</div>

								<div class="col-sm-4 padding-top-1">
									<div class="payments-section padding-1">
										<div class="row ">
											<div class="col-sm-6">
												<p>
													<i class="fa fa-credit-card" aria-hidden="true"></i> Debit
													Card
												</p>
											</div>
											<div class="col-sm-6">
												<i class="fa fa-ellipsis-v float-right" aria-hidden="true"></i>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-12">
												<p class="caption_payment">MasterCard,Visa,Verve</p>
											</div>
										</div>
									</div>
								</div>

							</div>

							<div class="row">

								<div class="col-sm-4 padding-top-1">
									<div class="payments-section padding-1">
										<div class="row ">
											<div class="col-sm-6">
												<p>
													<i class="fa fa-money iconpad" aria-hidden="true"></i> Paga
												</p>
											</div>
											<div class="col-sm-6">
												<i class="fa fa-ellipsis-v float-right" aria-hidden="true"></i>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-12">
												<p class="caption_payment">Agent Locations around the
													country</p>
											</div>
										</div>
									</div>
								</div>


								<div class="col-sm-4 padding-top-1">
									<div class="payments-section padding-1">
										<div class="row ">
											<div class="col-sm-6">
												<p>
													<i class="fa fa-mobile iconpad" aria-hidden="true"></i>
													USSD
												</p>
											</div>
											<div class="col-sm-6">
												<i class="fa fa-ellipsis-v float-right" aria-hidden="true"></i>
											</div>
										</div>

										<div class="row">
											<div class="col-sm-12">
												<p class="caption_payment">*673#</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<hr />

							<div class="row padding-top-1">
								<div class="col-sm-3">
									<button
										class="btn report-btn float-right btn-block no-border-radius"
										data-toggle="modal" data-target="#account">
										<i class="fa fa-plus iconpad" aria-hidden="true"></i>Add
										Account
									</button>
								</div>
								<div class="modal fade" id="account" tabindex="-1" role="dialog"
									aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content top-border justify-content-center">
											<div class="text-center">
												<h5 class="modal-title padding-top-1" id="exampleModalLabel">New
													Institution</h5>
											</div>
											<div class="modal-body">
												<div class="row">
													<div class="col-sm-12">
														<p class="green-color">
															<i class="fa fa-picture-o uploadimg iconpad"
																aria-hidden="true"></i> Upload Logo(JPEG,PNG)
														</p>
													</div>
												</div>
												<div class="row padding-bottom-1">
													<div class="col-sm-12">
														<select class="form-control po-offer">
															<option>Bank</option>
														</select>
													</div>
												</div>

												<div class="row padding-bottom-1">
													<div class="col-sm-12">
														<input type="text" placeholder="Account Number"
															class="form-control po-offer" />
													</div>
												</div>

												<div class="row padding-bottom-1">
													<div class="col-sm-12">
														<input type="text" placeholder="Account Name"
															class="form-control po-offer" />
													</div>
												</div>


												<div
													class="row padding-bottom-1 padding-top-1 justify-content-center">
													<div class="col-sm-5">
														<button class="btn pobtn btn-block pobtn1">Add
															Institution</button>
													</div>
												</div>



											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-9 d-flex justify-content-center">
									<div class="col-sm-6">
										<p>Reconciliation Accounts</p>
									</div>
								</div>
							</div>

							<div class="row padding-top-1">
								<div class="col-sm-4">
									<div class="payments-section">
										<div class="row padding-1">
											<div class="col-sm-6">
												<p>
													<img src="images/stanbic.png" class="reconciliation" />
													Stanbic IBTC
												</p>
											</div>
											<div class="col-sm-6">
												<p class="float-right">1087654778</p>
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="payments-section">
										<div class="row padding-1">
											<div class="col-sm-6">
												<p>
													<img src="images/citi.png" class="reconciliation" /> Citi
													Bank
												</p>
											</div>
											<div class="col-sm-6">
												<p class="float-right">1087654778</p>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>

						<div class="tab-pane fade main-tabpane content-height"
							id="reports" role="tabpanel" aria-labelledby="pills-home-tab">
							<div class="row">

								<div class="col-sm-3">
									<p>Transactions</p>
								</div>
								<div class="col-sm-4 offset-sm-5">
									<div class="input-group mb-3">
										<input type="text" placeholder="Search..."
											class="form-control form-right no-border-radius formcolor" />
										<div class="input-group-append">
											<span class="input-group-text formcolor no-border-radius"
												id="basic-addon2"><i class="fa fa-search iconpad "
												aria-hidden="true"></i></span>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-sm-1">
									<p>Filters:</p>
								</div>
								<div class="col-sm-2">
									<select
										class="form-control po-offer selectlist  no-border-radius">
										<option>Asset Type</option>
									</select>
								</div>

								<div class="col-sm-2">
									<select
										class="form-control po-offer selectlist  no-border-radius">
										<option>Offer Type</option>
									</select>
								</div>

								<div class="col-sm-2">
									<select
										class="form-control po-offer selectlist  no-border-radius">
										<option>Payment Method</option>
									</select>
								</div>

								<div class="col-sm-2">
									<select
										class="form-control po-offer selectlist  no-border-radius generali">
										<option>Status</option>
									</select>
								</div>
								<div class="col-sm-3">
									<div class="input-group mb-3">
										<input type="date"
											class="form-control selectlist no-border-radius datefilter"
											placeholder="Recipient's username"
											aria-label="Recipient's username"
											aria-describedby="basic-addon2" />
										<div class="input-group-append">
											<input type="date"
												class="form-control selectlist no-border-radius datefilter"
												placeholder="Recipient's username"
												aria-label="Recipient's username"
												aria-describedby="basic-addon2" />
										</div>
									</div>
								</div>

							</div>

							<div class="row">
								<div class="col-sm-2">
									<p class="mt-3 green-color">
										Clear Filters
										<!-- &times;-->
									</p>
								</div>

								<div class="col-sm-3 offset-sm-7">
									<button
										class="btn btn-block report-btn text-left mt-2 no-border-radius generater">
										<i class="fa fa-file-excel-o generateicon iconpad"
											aria-hidden="true"></i>Generate Report
									</button>
								</div>
							</div>
							<hr />

							<div class="col-sm-12">
								<div class="row padding-top-1">
									<div class="col-sm-12">
										<div class="row row-head-color">
											<div class="col-sm-3">
												<p>Investor</p>
											</div>

											<div class="col-sm-1">
												<p>Asset</p>
											</div>

											<div class="col-sm-1">
												<p>Type</p>
											</div>

											<div class="col-sm-2">
												<p>Units</p>
											</div>

											<div class="col-sm-2">
												<p>Amount(N)</p>
											</div>

											<div class="col-sm-2">
												<p>Date</p>
											</div>

											<div class="col-sm-1">
												<p>Status</p>
											</div>
										</div>

										<div class="row padding-top-1 polist">
											<div class="col-sm-3">
												<ul class="list-unstyled">
													<li class="media">
														<div class="media-body">
															<h7 class="mt-0 mb-1">Babatunde Akinyemi</h7>
														</div>
													</li>
												</ul>
											</div>

											<div class="col-sm-1">
												<p>MTNNG</p>
											</div>

											<div class="col-sm-1">
												<p>Stock</p>
											</div>

											<div class="col-sm-2">
												<p>42,000</p>
											</div>

											<div class="col-sm-2">
												<p>430,069.50</p>
											</div>

											<div class="col-sm-2">
												<p>02/01/2018</p>
											</div>

											<div class="col-sm-1">
												<p>Alloted</p>
											</div>
										</div>
										<hr class="customhr" />


										<div class="row padding-top-1 polist">
											<div class="col-sm-3">
												<ul class="list-unstyled">
													<li class="media">
														<div class="media-body">
															<h7 class="mt-0 mb-1">Babatunde Akinyemi</h7>
														</div>
													</li>
												</ul>
											</div>

											<div class="col-sm-1">
												<p>MTNNG</p>
											</div>

											<div class="col-sm-1">
												<p>Stock</p>
											</div>

											<div class="col-sm-2">
												<p>42,000</p>
											</div>

											<div class="col-sm-2">
												<p>430,069.50</p>
											</div>

											<div class="col-sm-2">
												<p>02/01/2018</p>
											</div>

											<div class="col-sm-1">
												<p>Alloted</p>
											</div>
										</div>
										<hr class="customhr" />


										<div class="row padding-top-1 polist">
											<div class="col-sm-3">
												<ul class="list-unstyled">
													<li class="media">
														<div class="media-body">
															<h7 class="mt-0 mb-1">Babatunde Akinyemi</h7>
														</div>
													</li>
												</ul>
											</div>

											<div class="col-sm-1">
												<p>MTNNG</p>
											</div>

											<div class="col-sm-1">
												<p>Stock</p>
											</div>

											<div class="col-sm-2">
												<p>42,000</p>
											</div>

											<div class="col-sm-2">
												<p>430,069.50</p>
											</div>

											<div class="col-sm-2">
												<p>02/01/2018</p>
											</div>

											<div class="col-sm-1">
												<p>Alloted</p>
											</div>
										</div>
										<hr class="customhr" />


										<div class="row padding-top-1 polist">
											<div class="col-sm-3">
												<ul class="list-unstyled">
													<li class="media">
														<div class="media-body">
															<h7 class="mt-0 mb-1">Babatunde Akinyemi</h7>
														</div>
													</li>
												</ul>
											</div>

											<div class="col-sm-1">
												<p>MTNNG</p>
											</div>

											<div class="col-sm-1">
												<p>Stock</p>
											</div>

											<div class="col-sm-2">
												<p>42,000</p>
											</div>

											<div class="col-sm-2">
												<p>430,069.50</p>
											</div>

											<div class="col-sm-2">
												<p>02/01/2018</p>
											</div>

											<div class="col-sm-1">
												<p>Alloted</p>
											</div>
										</div>
										<hr class="customhr" />
									</div>
								</div>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> <!-- /.End Gutter -->