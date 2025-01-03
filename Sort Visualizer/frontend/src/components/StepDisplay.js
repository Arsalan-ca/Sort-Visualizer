import React from 'react';

/**
 * The `StepDisplay` component is a functional React component
 * that displays information about a single step in a sorting process.
 *
 * @param {Object} props - The properties passed to the component.
 * @param {Object} props.step - The step data to be displayed.
 * @param {string} props.step.description - A textual description of the step.
 * @param {number[]} props.step.array - The state of the array at this step.
 *
 * @returns {JSX.Element} A JSX element displaying the step description and array state.
 */
function StepDisplay({ step }) {
  return (
    <div>
      <p>{step.description}</p>
      <p>Array: {step.array.join(', ')}</p>
    </div>
  );
}

export default StepDisplay;
