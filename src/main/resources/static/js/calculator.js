$(document).ready(function(){
    // Установка значений по умолчанию
    $('#input').val('');    
    $('#output').val('');
    
    // Отключение доступности кнопок 
    $('#btnClear').attr('disabled','disabled');
    $('#btnCalculate').attr('disabled','disabled');
    $('#btnCancel').attr('disabled','disabled');

    // Включение кнопки вычисления только если в строке есть значение
    $('#input').on('keyup',function(){
        if ($('#input').val().length > 0)
            $('#btnCalculate').removeAttr('disabled');
        else
            $('#btnCalculate').attr('disabled','disabled');
    });

    // Установка логики для кнопки "Очистить"
    $('#btnClear').click(function() {
        // Проверка доступности кнопки
        if (typeof $('#btnClear').attr('disabled') === typeof undefined)
        {
            $('#output').val('');                       // Очистка поля вывода 
            $('#btnClear').attr('disabled','disabled');         // Отключение
        }
        return false;   // Для отключения перехода по ссылке
    });

    // Установка логики для кнопки "Вычислить"
    $('#btnCalculate').click(function() {
        // Проверка доступности кнопки
        if (typeof $('#btnCalculate').attr('disabled') === typeof  undefined)
        {
            expression = $('#input').val();             // Получение значения
            $('#btnCalculate').attr('disabled','disabled');     // Отключение
            $('#input').val('');                        // Очистка поля ввода
            
            // Отправка запроса на сервер для расчёта
            $.ajax({
                url: '/public/rest/calculator',
                method: 'get',
                data: { expression : expression },
                dataType: 'json',
                success: function(data){
                    // Вывод полученного значения 
                    $('#output').val($.trim(data.result + '\n' + $('#output').val()));
                    // Включение кнопки "Очистить"
                    $('#btnClear').removeAttr('disabled');
                    // Включение кнопки "Отмена" в зависимости от наличия истории
                    if (data.empty)
                        $('#btnCancel').attr('disabled','disabled');
                    else
                        $('#btnCancel').removeAttr('disabled');
                }
            });
        }
        return false;   // Для отключения перехода по ссылке
    });

    // Установка логики для кнопки "Отмена"
    $('#btnCancel').click(function() {
        // Проверка доступности кнопки
        if (typeof $('#btnCancel').attr('disabled') === typeof undefined)
        {
            // Отправка запроса на сервер для получение последнего выражения
            $.ajax({
                url: '/public/rest/calculator/getLast',
                method: 'get',
                dataType: 'json',
                success: function(data){
                    // Запись значения в поле ввода
                    $('#input').val(data.result);
                    // Корректировка поля вывода
                    var s = $('#output').val();
                    if (s.search('\n') === -1)
                    {
                        $('#output').val('');
                        $('#btnClear').attr('disabled','disabled'); // Отключение
                    }
                    else
                        $('#output').val(s.substring(s.search('\n') + 1, s.length));
                    // Включение кнопки "Вычислить"
                    $('#btnCalculate').removeAttr('disabled');
                    // Включение кнопки "Отмена" в зависимости от наличия истории
                    if (data.empty)
                        $('#btnCancel').attr('disabled','disabled');
                }
            });
        }
        return false;   // Для отключения перехода по ссылке
    });
});
