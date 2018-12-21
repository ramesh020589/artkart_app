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
            </ul>
        </div>
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${cart?.items}" var="item" status="i">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td>${item.name}</td>
                        <td>${item.cost}</td>

                        <td><g:link controller="cart" action="removeFromCart" params="[id:item.id]">Remove</g:link> </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
    </body>
</html>
