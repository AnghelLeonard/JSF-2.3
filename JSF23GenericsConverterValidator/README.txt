As you probably know, in JSF 2.2 we can write a custom converter by extending the Converter interface, and a custom validator by extending the Validator interface. The methods defined in these interfaces works with Object class, but JSF 2.3 has added support for  generic parameters in Converter<T> and Validator<T>.

Arjan Tijms page: http://arjan-tijms.omnifaces.org/p/jsf-23.html
OmniFaces blog:   http://www.omnifaces-fans.org/2015/11/jsf-23-take-advantage-of-new-generic.html