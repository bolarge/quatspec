<%@ include file="/WEB-INF/tags.jsp"%>

<div class="container-fluid">

            <!--Section: Modals-->
            <section>

                <!--Modal: modalConfirmDelete-->
                <div class="modal fade" id="modalConfirmDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
                        <!--Content-->
                        <div class="modal-content text-center">
                            <!--Header-->
                            <div class="modal-header d-flex justify-content-center">
                                <p class="heading">Are you sure?</p>
                            </div>

                            <!--Body-->
                            <div class="modal-body">

                                <i class="fa fa-times fa-4x animated rotateIn"></i>

                            </div>

                            <!--Footer-->
                            <div class="modal-footer flex-center">
                                <a href="https://mdbootstrap.com/product/material-design-for-bootstrap-pro/" class="btn  btn-danger">Yes</a>
                                <a type="button" class="btn btn-outline-danger waves-effect" data-dismiss="modal">No</a>
                            </div>
                        </div>
                        <!--/.Content-->
                    </div>
                </div>
                <!--Modal: modalConfirmDelete-->

            </section>
            <!--Section: Modals-->

            <!--Section: Main panel-->
            <section class="card card-cascade narrower mb-5">

                <!--Grid row-->
                <div class="row">

                    <!--Grid column-->
                    <div class="col-md-5">

                        <!--Panel Header-->
                        <div class="view view-cascade py-3 gradient-card-header info-color-dark">
                            <h5 class="mb-0">Sales</h5>
                        </div>
                        <!--/Panel Header-->

                        <!--Panel content-->
                        <div class="card-body card-body-cascade">

                            <!--Grid row-->
                            <div class="row">

                                <!--Grid column-->
                                <div class="col-md-6 mb-4">

                                    <!--Date select-->
                                    <p class="lead">
                                        <span class="badge info-color-dark p-2">Date range</span>
                                    </p>
                                    <select class="mdb-select colorful-select dropdown-info">
                                        <option value="" disabled selected>Choose time period</option>
                                        <option value="1">Today</option>
                                        <option value="2">Yesterday</option>
                                        <option value="3">Last 7 days</option>
                                        <option value="3">Last 30 days</option>
                                        <option value="3">Last week</option>
                                        <option value="3">Last month</option>
                                    </select>

                                    <!--Date pickers-->
                                    <p class="lead my-4">
                                        <span class="badge info-color-dark p-2">Custom date</span>
                                    </p>
                                    <div class="md-form">
                                        <input placeholder="Selected date" type="text" id="from" class="form-control datepicker">
                                        <label for="date-picker-example">From</label>
                                    </div>
                                    <div class="md-form">
                                        <input placeholder="Selected date" type="text" id="to" class="form-control datepicker">
                                        <label for="date-picker-example">To</label>
                                    </div>

                                </div>
                                <!--Grid column-->

                                <!--Grid column-->
                                <div class="col-md-6 mb-4 text-center">

                                    <!--Summary-->
                                    <p>Total sales:
                                        <strong>2000$</strong>
                                        <button type="button" class="btn btn-info btn-sm p-2" data-toggle="tooltip" data-placement="top" title="Total sales in the given period">
                                            <i class="fa fa-question"></i>
                                        </button>
                                    </p>
                                    <p>Average sales:
                                        <strong>100$</strong>
                                        <button type="button" class="btn btn-info btn-sm p-2" data-toggle="tooltip" data-placement="top" title="Average daily sales in the given period">
                                            <i class="fa fa-question"></i>
                                        </button>
                                    </p>

                                    <!--Change chart-->
                                    <span class="min-chart my-4" id="chart-sales" data-percent="76">
                                        <span class="percent"></span>
                                    </span>
                                    <h5>
                                        <span class="badge green p-2">Change
                                            <i class="fa fa-arrow-circle-up ml-1"></i>
                                        </span>
                                        <button type="button" class="btn btn-info btn-sm p-2" data-toggle="tooltip" data-placement="top" title="Percentage change compared to the same period in the past">
                                            <i class="fa fa-question"></i>
                                        </button>
                                    </h5>

                                </div>
                                <!--Grid column-->

                            </div>
                            <!--Grid row-->

                        </div>
                        <!--Panel content-->

                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-md-7">

                        <!--Panel Header-->
                        <div class="view view-cascade py-3 gradient-card-header info-color-dark mb-4">

                            <canvas id="lineChart"></canvas>

                        </div>
                        <!--/Card image-->

                    </div>
                    <!--Grid column-->

                </div>
                <!--Grid row-->

            </section>
            <!--Section: Main panel-->

            <!--Section: Table-->
            <section class="mb-5">

                <!--Top Table UI-->
                <div class="card p-2 mb-5">

                    <!--Grid row-->
                    <div class="row">

                        <!--Grid column-->
                        <div class="col-lg-3 col-md-12">

                            <!--Name-->
                            <select class="mdb-select colorful-select dropdown-primary mx-2">
                                <option value="" disabled selected>Bulk actions</option>
                                <option value="1">Delete</option>
                                <option value="2">Export</option>
                                <option value="3">Change segment</option>
                            </select>

                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-lg-3 col-md-6">

                            <!--Blue select-->
                            <select class="mdb-select colorful-select dropdown-primary mx-2">
                                <option value="" disabled selected>Show only</option>
                                <option value="1">All
                                    <span> (2000)</span>
                                </option>
                                <option value="2">Never opened
                                    <span> (200)</span>
                                </option>
                                <option value="3">Opened but unanswered
                                    <span> (1800)</span>
                                </option>
                                <option value="4">Answered
                                    <span> (200)</span>
                                </option>
                                <option value="5">Unsunscribed
                                    <span> (50)</span>
                                </option>
                            </select>
                            <!--/Blue select-->

                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-lg-3 col-md-6">

                            <!--Blue select-->
                            <select class="mdb-select colorful-select dropdown-primary mx-2">
                                <option value="" disabled selected>Filter segments</option>
                                <option value="1">Contacts in no segments
                                    <span> (100)</span>
                                </option>
                                <option value="1">Segment 1
                                    <span> (2000)</span>
                                </option>
                                <option value="2">Segment 2
                                    <span> (1000)</span>
                                </option>
                                <option value="3">Segment 3
                                    <span> (4000)</span>
                                </option>
                            </select>
                            <!--/Blue select-->

                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-lg-3 col-md-6">

                            <form class="md-form form-inline mt-2 ml-2">
                                <input class="form-control my-0" type="text" placeholder="Search" style="max-width: 150px;">
                                <button class="btn btn-sm btn-info ml-2 px-2">
                                    <i class="fa fa-search"></i>
                                </button>
                            </form>

                        </div>
                        <!--Grid column-->

                    </div>
                    <!--Grid row-->

                </div>
                <!--Top Table UI-->

                <!--Card-->
                <div class="card card-cascade narrower">

                    <!--Card header-->
                    <div class="view view-cascade py-3 gradient-card-header info-color-dark mx-4 d-flex justify-content-between align-items-center">

                        <div>
                            <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
                                <i class="fa fa-th-large mt-0"></i>
                            </button>
                            <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
                                <i class="fa fa-columns mt-0"></i>
                            </button>
                        </div>

                        <a href="" class="white-text mx-3">Table name</a>

                        <div>
                            <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
                                <i class="fa fa-pencil mt-0"></i>
                            </button>
                            <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2" data-toggle="modal" data-target="#modalConfirmDelete">
                                <i class="fa fa-remove mt-0"></i>
                            </button>
                            <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
                                <i class="fa fa-info-circle mt-0"></i>
                            </button>
                        </div>

                    </div>
                    <!--/Card header-->

                    <!--Card content-->
                    <div class="card-body card-body-cascade">

                        <div class="table-responsive">

                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="form-check-input" type="checkbox" id="checkbox">
                                            <label for="checkbox" class="label-table form-check-label"></label>
                                        </th>
                                        <th class="th-lg">First column</th>
                                        <th class="th-lg">Second column</th>
                                        <th class="th-lg">Third column</th>
                                        <th class="th-lg">Fourth column</th>
                                        <th class="th-lg">Fifth column</th>
                                        <th class="th-lg">Sixth column</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">
                                            <input class="form-check-input" type="checkbox" id="checkbox1">
                                            <label for="checkbox1" class="label-table form-check-label"></label>
                                        </th>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">
                                            <input class="form-check-input" type="checkbox" id="checkbox2">
                                            <label for="checkbox2" class="label-table form-check-label"></label>
                                        </th>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">
                                            <input class="form-check-input" type="checkbox" id="checkbox3">
                                            <label for="checkbox3" class="label-table form-check-label"></label>
                                        </th>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                        <td>Lorem Ipsum</td>
                                    </tr>
                                </tbody>
                            </table>

                        </div>

                        <hr class="my-0">

                        <!--Bottom Table UI-->
                        <div class="d-flex justify-content-between">

                            <!--Name-->
                            <select class="mdb-select colorful-select dropdown-primary mt-2 hidden-md-down">
                                <option value="" disabled>Rows number</option>
                                <option value="1" selected>10 rows</option>
                                <option value="2">25 rows</option>
                                <option value="3">50 rows</option>
                                <option value="4">100 rows</option>
                            </select>

                            <!--Pagination -->
                            <nav class="my-4">
                                <ul class="pagination pagination-circle pg-blue mb-0">

                                    <!--First-->
                                    <li class="page-item disabled">
                                        <a class="page-link">First</a>
                                    </li>

                                    <!--Arrow left-->
                                    <li class="page-item disabled">
                                        <a class="page-link" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                            <span class="sr-only">Previous</span>
                                        </a>
                                    </li>

                                    <!--Numbers-->
                                    <li class="page-item active">
                                        <a class="page-link">1</a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link">2</a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link">3</a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link">4</a>
                                    </li>
                                    <li class="page-item">
                                        <a class="page-link">5</a>
                                    </li>

                                    <!--Arrow right-->
                                    <li class="page-item">
                                        <a class="page-link" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                            <span class="sr-only">Next</span>
                                        </a>
                                    </li>

                                    <!--First-->
                                    <li class="page-item">
                                        <a class="page-link">Last</a>
                                    </li>

                                </ul>
                            </nav>
                            <!--/Pagination -->

                        </div>
                        <!--Bottom Table UI-->

                    </div>
                    <!--/.Card content-->

                </div>
                <!--/.Card-->

            </section>
            <!--Section: Table-->

            <!--Section: Accordion-->
            <section class="mb-5">

                <!--Accordion wrapper-->
                <div class="accordion" id="accordionEx" role="tablist" aria-multiselectable="true">

                    <!-- Accordion card -->
                    <div class="card">

                        <!-- Card header -->
                        <div class="card-header" role="tab" id="headingOne">

                            <!--Options-->
                            <div class="dropdown pull-left">
                                <button class="btn btn-info btn-sm m-0 mr-3 p-2 dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                    <i class="fa fa-pencil"></i>
                                </button>
                                <div class="dropdown-menu dropdown-info">
                                    <a class="dropdown-item" href="#">Add new</a>
                                    <a class="dropdown-item" href="#">Rename folder</a>
                                    <a class="dropdown-item" href="#">Delete folder</a>
                                </div>
                            </div>

                            <!-- Heading -->
                            <a id="folder-1" data-toggle="collapse" data-parent="#accordionEx" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                <h5 class="mt-1 mb-0">
                                    <span>Folder 1</span>
                                    <i class="fa fa-angle-down rotate-icon"></i>
                                </h5>
                            </a>

                        </div>

                        <!-- Card body -->
                        <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
                            <div class="card-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute,
                                non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch
                                3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda
                                shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                                sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                                farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                                labore sustainable VHS.
                            </div>
                        </div>
                    </div>
                    <!-- Accordion card -->

                    <!-- Accordion card -->
                    <div class="card">

                        <!-- Card header -->
                        <div class="card-header" role="tab" id="headingTwo">

                            <!--Options-->
                            <div class="dropdown pull-left">
                                <button class="btn btn-info btn-sm m-0 mr-3 p-2 dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                    <i class="fa fa-pencil"></i>
                                </button>
                                <div class="dropdown-menu dropdown-info">
                                    <a class="dropdown-item" href="#">Add new</a>
                                    <a class="dropdown-item" href="#">Rename folder</a>
                                    <a class="dropdown-item" href="#">Delete folder</a>
                                </div>
                            </div>

                            <!-- Heading -->
                            <a id="folder-2" data-toggle="collapse" data-parent="#accordionEx" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                                <h5 class="mt-1 mb-0">
                                    <span>Folder 2</span>
                                    <i class="fa fa-angle-down rotate-icon"></i>
                                </h5>
                            </a>

                        </div>

                        <!-- Card body -->
                        <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
                            <div class="card-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute,
                                non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch
                                3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda
                                shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                                sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                                farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                                labore sustainable VHS.
                            </div>
                        </div>
                    </div>
                    <!-- Accordion card -->

                    <!-- Accordion card -->
                    <div class="card">

                        <!-- Card header -->
                        <div class="card-header" role="tab" id="headingThree">

                            <!--Options-->
                            <div class="dropdown pull-left">
                                <button class="btn btn-info btn-sm m-0 mr-3 p-2 dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                    <i class="fa fa-pencil"></i>
                                </button>
                                <div class="dropdown-menu dropdown-info">
                                    <a class="dropdown-item" href="#">Add new</a>
                                    <a class="dropdown-item" href="#">Rename folder</a>
                                    <a class="dropdown-item" href="#">Delete folder</a>
                                </div>
                            </div>

                            <!-- Heading -->
                            <a id="folder-3" data-toggle="collapse" data-parent="#accordionEx" href="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
                                <h5 class="mt-1 mb-0">
                                    <span>Folder 3</span>
                                    <i class="fa fa-angle-down rotate-icon"></i>
                                </h5>
                            </a>
                        </div>

                        <!-- Card body -->
                        <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree">
                            <div class="card-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute,
                                non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch
                                3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda
                                shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt
                                sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer
                                farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                                labore sustainable VHS.
                            </div>
                        </div>
                    </div>
                    <!-- Accordion card -->
                </div>
                <!--/.Accordion wrapper-->

            </section>
            <!--Section: Accordion-->

        </div>