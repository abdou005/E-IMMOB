$(document).ready(function() {
     // Generate a simple captcha
    function randomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    };
    function generateCaptcha() {
        $('#captchaOperation').html([randomNumber(1, 50), '+', randomNumber(1, 100), '='].join(' '));
    };
    generateCaptcha();
    $('#defaultForm')
        .formValidation({
            message: 'Cette valeur ne est pas valide',
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                firstName: {
                    validators: {
                        notEmpty: {
                            message: 'Le premier nom est obligatoire et ne peut être vide'
                        }
                    }
                },
                lastName: {
                    validators: {
                        notEmpty: {
                            message: 'Le dernier nom est obligatoire et ne peut être vide'
                        }
                    }
                },            
                email: {
                    validators: {
                         notEmpty: {
                        message: 'adresse email est requise'
                         },
                        emailAddress: {
                            message: "L'entrée ne est pas une adresse email valide"
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: 'Le mot de passe est nécessaire et ne peut pas être vide'
                        },
                        stringLength: {
                            min: 6,
                            message: 'Le mot de passe doit etre superieur a 6 caractere'
                        },
                        different: {
                            field: 'firstName',
                            message: "Le mot de passe ne peut pas être le même que le nom d'utilisateur"
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: 'Le mot de passe de confirmation est nécessaire et ne peut pas être vide'
                        },
                        identical: {
                            field: 'password',
                            message: 'Le mot de passe et son confirmation ne sont pas identiques'
                        }
                    }
                },
                senderPhone: {
                        message: 'Le numéro de téléphone ne est pas valable',
                        validators: {
                            notEmpty: {
                                message: 'Le numéro de téléphone est obligatoire'
                            },
                            digits: {
                                message: 'La valeur peut contenir que des chiffres'
                            }
                        }
                    },
                    senderAddress: {
                        validators: {
                            notEmpty: {
                                message: "L'adresse est nécessaire"
                            }
                        }
                    },
                gender: {
                    validators: {
                        notEmpty: {
                            message: 'Le type est nécessaire'
                        }
                    }
                },
                captcha: {
                    validators: {
                        callback: {
                            message: 'mauvaise réponse',
                            callback: function(value, validator, $field) {
                                var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
                                return value == sum;
                            }
                        }
                    }
                }
            }
        })
        .on('err.form.fv', function(e) {
            console.log('err.form.fv');

            // You can get the form instance and then access API
            var $form = $(e.target);
            console.log($form.data('formValidation').getInvalidFields());

            // If you want to prevent the default handler (formValidation._onError(e))
            // e.preventDefault();
        })
        .on('success.form.fv', function(e) {
            console.log('success.form.fv');

            // If you want to prevent the default handler (formValidation._onSuccess(e))
            // e.preventDefault();
        })
        .on('err.field.fv', function(e, data) {
            console.log('err.field.fv -->', data);
        })
        .on('success.field.fv', function(e, data) {
            console.log('success.field.fv -->', data);
        })
        .on('status.field.fv', function(e, data) {
            // I don't want to add has-success class to valid field container
            data.element.parents('.form-group').removeClass('has-success');

            // I want to enable the submit button all the time
            data.fv.disableSubmitButtons(false);
        });
});
