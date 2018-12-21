<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'cart.label', default: 'Cart')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-cart" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li> <g:link controller="item" action="index">Item List</g:link></li>
        <g:link controller="cart" action="show">Go To Cart</g:link>
    </ul>
</div>
<div id="show-item" class="content scaffold-show" role="main">
<h1>${user.firstName}'s Profile</h1>
    <div>
        <span class="property-label">First Name : </span> ${user.firstName}
    </div>
    <div>
        <span class="property-label">Last Name : </span> ${user.lastName}
    </div>
    <div>
        <span class="property-label">Age : </span>${user.age}
    </div>
        <span class="property-label">Mobile : </span>${user.mobileNumber}
    </div>
    <div>
        <span class="property-label">Email : ${user.email}</span>
    </div>
</div>
</body>
</html>
