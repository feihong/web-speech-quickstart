let voices = []

function populateVoiceList() {
  voices = speechSynthesis.getVoices();

  for (let voice of voices) {
    console.log(voice.name)
  }
}

populateVoiceList()
speechSynthesis.onvoiceschanged = populateVoiceList

function speak() {
  let utter = new SpeechSynthesisUtterance('Hello World')
  speechSynthesis.speak(utter)
}

$('.speak').on('click', speak)

$('.speak-callback').on('click', () => {
  setTimeout(speak, 100)
})
