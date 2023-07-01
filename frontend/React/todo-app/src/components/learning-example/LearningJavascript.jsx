const person = {
  name: 'Hemant',
  age: 24,
  address: {
    line1: '11 street',
    city: 'Motihari',
    state: 'Bihar'
  },
  profiles: ['twitter', 'facebook', 'linkedin'],
  printProfile: () => {
    person.profiles.map(
      profile => console.log(profile)
    )
  }
}

export default function LearningJavascript(){
  return (
    <>
    <div>{person.name}</div>
    <div>{person.age}</div>
    <div>{person.address.line1}</div>
    <div>{person.profiles[2]}</div>
    <div>{person.printProfile()}</div>
    </>
  )
}