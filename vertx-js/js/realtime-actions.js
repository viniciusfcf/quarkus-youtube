
function init() {
    registerHandler();
};

function registerHandler() {
    var eventBus = new EventBus('http://localhost:8080/eventbus');
    eventBus.onopen = function () {
        eventBus.registerHandler('olaPublish', function (error, message) {
            document.getElementById('feed').value +=message.body+'\n\n----------------\n\n';
        });
    }
};

