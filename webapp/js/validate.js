  $(document).ready(function() {
    $('#signup').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            hostname: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Please supply Hostname'
                    }
                }
            },
             db_name: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply DB Name'
                    }
                }
            },
            db_path: {
                validators: {
                    stringLength: {
                       min: 4,
                   },
                   notEmpty: {
                       message: 'Please supply DB Path'
                   }
               }
           },
            port: {
                validators: {
                	  stringLength: {
                          min: 3,
                      },
                    notEmpty: {
                        message: 'Please supply port number'
                    },
                 
                }
            },
            dlc_path: {
                validators: {
                     stringLength: {
                        min: 5,
                    },
                    notEmpty: {
                        message: 'Please supply dlc path'
                    }
                }
            },
            
            os: {
                validators: {
                    
                    notEmpty: {
                        message: 'Please supply os'
                    }
                }
            },
            
            version: {
                validators: {
                    
                    notEmpty: {
                        message: 'Please supply dlc version'
                    }
                }
            },
            
            'monitored': {
                validators: {
                    
                 
                }
            }
            
         
            }
        })
       .on('success.form.bv', function(e) {
    	   alert('here');
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#addDB').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log('heloo world');
            }, 'json');
        });
});