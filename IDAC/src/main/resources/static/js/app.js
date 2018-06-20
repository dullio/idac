$(document).ready(function () {
    $('#PersonTableContainer').jtable({
        title: 'Lista dos Membros',
        actions: {
            listAction: '/api/members/',
            createAction: '/api/members/',
            updateAction: '/api/members/',
            deleteAction: '/api/members/'
        },
        fields: {
            
            createdAt:{
                type: 'date',
                create: false,
                edit: false,
                list: false
            },
            
            updatedAt:{
                type: 'date',
                create: false,
                edit: false,
                list: false
            },          

            createdBy:{
                create: false,
                edit: false,
                list: false
            },

            modifiedBy:{
                create: false,
                edit: false,
                list: false
            },            
            
            id: {
                key: true,
                list: false
            },
            firstName: {
                title: 'Nome'

            },
            lastName: {
                title: 'Sobrenome'

            },
            userName:{
                create: false,
                edit: false,
                list: false
            },

            cpf: {
                title:'CPF'
            } ,
            
            rg: {
                title:'RG'
            },

            gender: {
                title:'Sexo'
            },

            note: {
                title:'CPF'
            },

            active: {
                title: 'Ativo',
                type: 'boolean'
            },

            birthday: {
                title: 'Nascimento',
                width: '30%',
                type: 'date',
                create: true,
                edit: true
            }
        }
    });
    	
$('#PersonTableContainer').jtable('load');

});