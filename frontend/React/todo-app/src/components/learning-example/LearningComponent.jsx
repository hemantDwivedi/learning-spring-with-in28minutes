import FirstComponent from './FirstComponent';
import {FifthComponent} from './FirstComponent';
import SecondComponent from './SecondComponent';
import ThirdComponent from './ThirdComponent';
import FourthComponent from './FourthComponent';
import LearningJavascript from './LearningJavascript';

function LearningComponent() {
  return (
    <div className="LearningComponent">
      <FirstComponent />
      <SecondComponent />
      <ThirdComponent />
      <FourthComponent />
      <FifthComponent />
      <LearningJavascript />
    </div>
  );
}

export default LearningComponent;