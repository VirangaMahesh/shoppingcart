export function getCommonAmountFormatForGrid(value) {
  let formattedValue = '-';
  if (value) {
    const amount = Math.floor(value * 1000) / 1000;
    const fractions = amount.toFixed(2).toString().split('.');
    fractions[0] = fractions[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    formattedValue = fractions.join('.');
    formattedValue = formattedValue + " LKR"
  }
  return formattedValue;
}
