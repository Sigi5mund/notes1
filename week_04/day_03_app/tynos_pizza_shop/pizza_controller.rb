require( 'sinatra' )
require( 'sinatra/reloader' )
require( 'pry-byebug' )

require_relative( './models/pizza' )

get '/pizzas' do # index
  @pizzas = Pizza.all()
  erb( :index )
end

get '/pizzas/new' do # new
  erb( :new )
end

get '/pizzas/:id' do # show
  @pizza = Pizza.find( params[:id] )
  erb( :show )
end

post '/pizzas' do # create
  @pizza = Pizza.new( params )
  @pizza.save()
  redirect to "/pizzas"
end

get '/thank-you' do
  erb :thankyou
end

get '/pizzas/:id/edit' do # edit
  @pizza = Pizza.find( params[:id] )
  erb( :edit )
end

put '/pizzas/:id' do # update
  Pizza.new( params ).update
  redirect to '/pizzas'
end

delete '/pizzas/:id' do # delete
  pizza = Pizza.find( params[:id] )
  pizza.delete()
  redirect to '/pizzas'
end