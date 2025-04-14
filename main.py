import apache_beam as beam

def compute_price(record):
    record['price'] = float(record['base_price']) * 1.2
    return record

with beam.Pipeline() as p:
    (p
     | 'ReadInput' >> beam.io.ReadFromText('input/prices.csv')
     | 'ParseCSV' >> beam.Map(lambda line: dict(zip(['item', 'base_price'], line.split(','))))
     | 'ComputePrice' >> beam.Map(compute_price)
     | 'WriteOutput' >> beam.io.WriteToText('output/prices'))
