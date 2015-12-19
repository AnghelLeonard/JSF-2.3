As you probably know JSF 2.2 comes with a solid support for injection in JSF artifacts. However, some artifacts were left out, and here we are talking about converters, validators and behaviors. Starting with JSF 2.3 this gap has been filled and we can inject (use @Inject) in @FacesConverter (javax.faces.convert.Converter), @FacesValidator (javax.faces.validator.Validator) and @FacesBehavior (javax.faces.component.behavior.Behavior).

Arjan Tijms page: http://arjan-tijms.omnifaces.org/p/jsf-23.html
OmniFaces blog:   http://www.omnifaces-fans.org/2015/11/jsf-23-converters-validators-and.html