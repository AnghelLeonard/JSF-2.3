As you probably know, JSF uses static entry methods and chaining to let the user obtain the various artifacts that it provides, such as the FacesContext, session map, external context, etc. But, this is pretty verbose and sometimes hard to intuit and understand. JSF 2.3 will therefore provide default producers for the most important artifacts. The entire list in available:

Arjan Tijms page: http://arjan-tijms.omnifaces.org/p/jsf-23.html
OmniFaces blog:   http://www.omnifaces-fans.org/2015/09/jsf-23-injection-and-el-resolving-of.html
		  http://www.omnifaces-fans.org/2015/12/jsf-23-default-producer-example.html