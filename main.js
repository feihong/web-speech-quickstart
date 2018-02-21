let voices = []

function populateVoiceList() {
  voices = speechSynthesis.getVoices();

  for (let voice of voices) {
    console.log(voice.name)
  }
}

populateVoiceList()
speechSynthesis.onvoiceschanged = populateVoiceList

function speak(text) {
  let phrase = 'Hello World'
  if (typeof text === 'string') {
    phrase = text
  }
  let utter = new SpeechSynthesisUtterance(phrase)
  speechSynthesis.speak(utter)
}

$('.speak').on('click', speak)

$('.speak-delay').on('click', () => {
  setTimeout(speak, 2000)
})

$('.speak-ajax').on('click', () => {
  $.getJSON('/data.json', data => {
    speak(data.text)
  })
})

$('.speak-ajax-delay').on('click', () => {
  $.getJSON('/data.json', data => {
    setTimeout(() => speak(data.text), 2000)
  })
})

$('.speak-repeat').on('click', () => {
  setInterval(speak, 2000)
})
