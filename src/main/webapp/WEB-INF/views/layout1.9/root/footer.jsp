<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../../layout/taglib.jsp"%>

   
        <div class="footer">
            <div class="container">
                <div class="row">
                    <!-- About -->
                    <div class="col-md-3 md-margin-bottom-40">
                       <a href="<c:url value='/'/>"><img class="footer-logo" src="<c:url value='/resources_1_9_5/img/logo1-default.png'/>" alt=""></a>
						
						
                    </div><!--/col-md-3-->
                    <!-- End About -->

                    <!-- Latest -->
                    <div class="col-md-3 md-margin-bottom-40">
                        <div class="posts">
                            <div class="headline"><h2>Latest Posts</h2></div>
                            <ul class="list-unstyled latest-list" id="footerLatestPosts">
                            	<%--Is Populated through an AJAX Call --%>
                            </ul>
                        </div>
                    </div><!--/col-md-3-->
                    <!-- End Latest -->

                    <!-- Link List -->
                    <div class="col-md-3 md-margin-bottom-40">
                        
                    </div><!--/col-md-3-->
                    <!-- End Link List -->

                    <!-- Address -->
                    <div class="col-md-3 map-img md-margin-bottom-40">
                        <div class="headline"><h2>Contact Us</h2></div>
                        <address class="md-margin-bottom-40">
                            Rodange, Luxembourg <br />
                            Europe <br />
                            Phone: +352 <br />
                            
                            Email: <a href="mailto:info@elevysi.com" class="">info@elevysi.com</a>
                        </address>
                    </div><!--/col-md-3-->
                    <!-- End Address -->
                </div>
            </div>
        </div><!--/footer-->

        <div class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <p>
                            2016 &copy; Elevysi. All Rights Reserved.
                           <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a>
                        </p>
                    </div>

                    <!-- Social Links -->
                    <div class="col-md-6">
                        <ul class="footer-socials list-inline">
                            <li>
                                <a href="#" class="tooltips" data-toggle="tooltip" data-placement="top" title="" data-original-title="Facebook">
                                    <i class="fa fa-facebook"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="tooltips" data-toggle="tooltip" data-placement="top" title="" data-original-title="Skype">
                                    <i class="fa fa-skype"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="tooltips" data-toggle="tooltip" data-placement="top" title="" data-original-title="Google Plus">
                                    <i class="fa fa-google-plus"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="tooltips" data-toggle="tooltip" data-placement="top" title="" data-original-title="Linkedin">
                                    <i class="fa fa-linkedin"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="tooltips" data-toggle="tooltip" data-placement="top" title="" data-original-title="Pinterest">
                                    <i class="fa fa-pinterest"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="tooltips" data-toggle="tooltip" data-placement="top" title="" data-original-title="Twitter">
                                    <i class="fa fa-twitter"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="tooltips" data-toggle="tooltip" data-placement="top" title="" data-original-title="Dribbble">
                                    <i class="fa fa-dribbble"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- End Social Links -->
                </div>
            </div>
        </div><!--/copyright-->
    
    
    
    <!-- ---------------------------------------------------------------------------------------------------- -->
	 <!--      Modal dedicated to login only -->
    <div id="showLoginModal"></div>
	<div id="loginmodalholder">

            <div class="modal" id ="dialog-login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            	<div class="modal-dialog">
	                <div class="modal-content">
	                  <div class="modal-header">
	                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                    <h4 class="modal-title" id="myModalLabel">Confetti Bucket</h4>
	                  </div>
	                  <div class="modal-body">
	                   
	                 
	                  
	                  </div>
	                  <div class="modal-footer">
	                    <button type="button" class="btn-u btn-u-default" data-dismiss="modal">Close</button>
	                    <button type="button" class="btn-u" id="modalLoginSubmitBtn">Login</button>
	                    
	                  </div>
	                </div>
              </div>
            </div>
     </div>
     <!-- ---------------------------------------------------------------------------------------------------- -->
    
    <!-- Add Model -->
    <div id="modalholder">

            <div class="modal" id ="modalAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

	            <div class="modal-dialog modal-lg">
	                <div class="modal-content">
	                  <div class="modal-header">
	                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                    <h4 class="modal-title" id="myModalLabel-add">Confetti Bucket</h4>
	                  </div>
	                  <div class="modal-body">
	                   
	                  </div>
	                  <div class="hide modal-hrefLink" href="">
	                  </div>
	                  
<!-- 	                  Used to flash Login Msgs -->
	                  <div id="modalFlashCommunications">
	                  </div>
	                  
	                  
	                  
	                  <div class="modal-footer">
	                    <button type="button" class="btn-u btn-u-default" data-dismiss="modal"><spring:message code="label.close"/></button>
						<button type="submit" class="btn-u btn-u-green saveBtn" id="saveModal"><spring:message code="label.save"/></button>
	                  </div>
	                </div>
	            </div>
            </div>

     </div>
	<!-- End of Add Model -->
	
<!-- JS Implementing Plugins -->
<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/back-to-top.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources_1_9_5/plugins/smoothScroll.js'/>"></script>
<script type="text/javascript" src="<c:url value='/thematic_1_9/Blog/assets/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js'/>"></script>

<!-- JS Customization -->
<script type="text/javascript" src="<c:url value='/resources_1_9_5/js/custom.js'/>"></script>

<!-- JS Page Level -->
<script type="text/javascript" src="<c:url value='/resources_1_9_5/js/app.js'/>"></script>

<script type="text/javascript">
	jQuery(document).ready(function() {
		App.init();
		FancyBox.initFancybox();
		App.initScrollBar();
	});
</script>
<!--[if lt IE 9]>
<script src="<c:url value='/resources_1_9_5/plugins/respond.js'/>"></script>
<script src="<c:url value='/resources_1_9_5/plugins/html5shiv.js'/>"></script>
<script src="<c:url value='/resources_1_9_5/plugins/placeholder-IE-fixes.js'/>"></script>
<![endif]-->

<tiles:insertAttribute name="bodyjs" />